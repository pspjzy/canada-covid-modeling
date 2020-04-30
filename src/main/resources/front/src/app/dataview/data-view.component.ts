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
  chart = [];


  dataview = [];


  constructor(private dService: DataViewService) {
  }

  ngOnInit(){
    this.dService.getData().subscribe(data => {
      this.dataview = data
      let deaths = this.dataview.map(data=>data.deaths)
      let cases = this.dataview.map(data=>data.cases)
      let todayCases = this.dataview.map(data=>data.todayCases)
      let recovered = this.dataview.map(data=>data.recovered)
      let critical = this.dataview.map(data=>data.critical)
      let tests = this.dataview.map(data=>data.tests)
      let rawTime = this.dataview.map(data=>new Date(data.time))
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

        console.log(time)


      this.chart = new Chart('canvas',{
        type: 'line',
        data: {
          labels: time,
          datasets: [
            {
              data: todayCases,
              borderColor:'#3cba9f',
              fill: false
            }
          ]

        },
        options: {
          scales: {
            yAxes: [{
              stacked: true
            }]
          }
        }

      })

    });

  }

}
