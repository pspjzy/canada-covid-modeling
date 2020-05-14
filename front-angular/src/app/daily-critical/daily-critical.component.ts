import { Component, OnInit } from '@angular/core';
import {DataViewService} from "../dataview/dataview.service";
import { Chart } from 'chart.js'

@Component({
  selector: 'app-daily-critical',
  templateUrl: './daily-critical.component.html',
  styleUrls: ['./daily-critical.component.css']
})
export class DailyCriticalComponent implements OnInit {
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
      let dCritical = this.dataview.map(data=>data.todayCritical).map((e, i, a) => {
        let prev = a[i - 1];
        let next = a[i + 1];
        if (e === prev && e === next) return '' + e;
        return e;
      }).map(e => typeof e === 'string' ? null : e);
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



      this.chart.push(new Chart('canvas2',{
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


    })
  }
}
