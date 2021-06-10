import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-history-table',
  templateUrl: './history-table.component.html',
  styleUrls: ['./history-table.component.css']
})
export class HistoryTableComponent {

  matches:any = [];
  fHistory: any = [];
  sHistory: any =[];

  constructor(private appService: AppService) {
    this.appService.getHistory().subscribe(data => {
      this.fHistory = data;
      this.sHistory.push((this.fHistory.history));
      this.matches = this.sHistory[0];
      console.log(this.matches)
    });
  }
}
