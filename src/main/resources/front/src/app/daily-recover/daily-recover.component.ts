import { Component, OnInit } from '@angular/core';
import {DataViewService} from "../dataview/dataview.service";
import { Chart } from 'chart.js'

@Component({
  selector: 'app-daily-recover',
  templateUrl: './daily-recover.component.html',
  styleUrls: ['./daily-recover.component.css']
})
export class DailyRecoverComponent implements OnInit {

  chart = [];
  dataview = [];
  constructor(private dService: DataViewService) {
  }

  ngOnInit() {
    this.dService.getData().subscribe(data => {
      let option = {
        legend: {},
        scales: {
          yAxes: [{
            stacked: true
          }]
        }
      }
      this.dataview = data
      let dRecovered = this.dataview.map(data=>data.todayRecovered)
      let hour = this.dataview.map(hour => {
        let date;
        let hr;
        date = new Date(hour.time)
        hr = date.getHours().toString()
        if (hr < 10) {
          hr = '0' + hr
        }
        return hr + ":00"

      })//需要test



      this.chart.push(new Chart('canvas4',{
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


    })
  }

}
