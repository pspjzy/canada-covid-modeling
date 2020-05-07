import { Component, OnInit } from '@angular/core';
import {DataViewService} from "./dataview.service";
import { Chart } from 'chart.js'
import {Data} from "../data";

@Component({
  selector: 'app-dataview',
  templateUrl: './data-view.component.html',
  styleUrls: ['./data-view.component.css']
})
export class DataViewComponent implements OnInit {
  chart1 = [];

  chart2 = [];

  chart3 = [];


  dataview = [];


  constructor(private dService: DataViewService) {
  }

  ngOnInit(){
    this.dService.getData().subscribe(data => {
      let option ={
        legend: {

        },
        scales: {
          yAxes: [{
            stacked: true
          }]
        }
      }
      this.dataview = data
      let todayCases = this.dataview.map(data=>data.todayCases)
      let todayCasesNoR = todayCases.map((e, i, a) => {
        let prev = a[i - 1];
        let next = a[i + 1];
        if (e === prev && e === next) return '' + e;
        return e;
      }).map(e => typeof e === 'string' ? null : e);
      let recovered = this.dataview.map(data=>data.recovered)
      let dDeath = this.dataview.map(data=>data.todayDeath)
      let dRecovered = this.dataview.map(data=>data.todayRecovered)
      let dCritical = this.dataview.map(data=>data.todayCritical)
      let dTest = this.dataview.map(data=>data.todayTest)
      let time = this.dataview.map(data=>{
        let date;
        let hour;
        let min;
        date = new Date(data.time)
        hour = date.getHours().toString()
        min = date.getMinutes().toString()
        if (min<10){
          min = '0' + min
        }
        if (hour<10){
          hour = '0' + hour
        }
        return hour + ":" + min

      })
      let hour = this.dataview.map(hour=>{
        let date;
        let hr;
        date = new Date(hour.time)
        hr = date.getHours().toString()
        if (hr<10){
          hr = '0' + hr
        }
        return hr + ":00"

      })//需要test

        console.log(time)


      this.chart1.push(new Chart('canvas1',{
        type: 'line',
        data: {
          labels: hour,
          datasets: [
            {
              label: "case discovered today",
              data: todayCasesNoR,
              spanGaps: true,
              borderColor:'#3cba9f',
              fill: false
            }
          ]

        },
        options: option

      }))

      this.chart1.push(new Chart('canvas2',{
        type: 'line',
        data: {
          labels: hour,
          datasets: [
            {
              label: "death today",
              data: dDeath,
              spanGaps: true,
              borderColor:'#000000',
              fill: false
            }
          ]

        },
        options: option

      }))

      this.chart1.push(new Chart('canvas3',{
        type: 'line',
        data: {
          labels: hour,
          datasets: [
            {
              label: "recovered case today",
              data: dRecovered,
              spanGaps: true,
              borderColor:'#12f119',
              fill: false
            },
          ]

        },
        options: option

      }))

      this.chart1.push(new Chart('canvas4',{
        type: 'line',
        data: {
          labels: hour,
          datasets: [
            {
              label: "test today",
              data: dTest,
              spanGaps: true,
              borderColor:'#db0f0f',
              fill: false
            },
          ]

        },
        options: option

      }))
      this.chart1.push(new Chart('canvas5',{
        type: 'line',
        data: {
          labels: hour,
          datasets: [
            {
              label: "Critical case",
              data: dCritical,
              spanGaps: true,
              borderColor:'#00178b',
              fill: false
            },
          ]

        },
        options: option

      }))

    });

  }

}
