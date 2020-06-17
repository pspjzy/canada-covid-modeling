import { Component, OnInit } from '@angular/core';
import {DataViewService} from "../dataview/dataview.service";
import { Chart } from 'chart.js'


@Component({
  selector: 'app-daily-test',
  templateUrl: './daily-test.component.html',
})
export class DailyTestComponent implements OnInit {

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
      let dTest = this.dataview.map(data=>data.todayTest).map((e, i, a) => {
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


      this.chart.push(new Chart('canvas5',{
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


    })
  }

}
