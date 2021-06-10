import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-search-history',
  templateUrl: './search-history.component.html',
  styleUrls: ['./search-history.component.css']
})
export class SearchHistoryComponent implements OnInit{

  matches:any = [];
  temp:any = [];
  fHistory: any = [];
  sHistory: any =[];

  constructor(private appService: AppService) {

  }

  dateInFormat(date) {
    let d = new Date(date),
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear();

    return [day, month, year].join('-');
  }

  getDate(item){
    this.matches = [];
    this.appService.getHistory().subscribe(data => {
      this.fHistory = data;
      this.sHistory.push((this.fHistory.history));
      this.temp = this.sHistory[0];
    });
    for (let i = 0; i < this.temp.length; i++){
      if (this.temp[i].dateAsString == (this.dateInFormat(item.value))){
        this.matches.push(this.temp[i])
      }
    }
  }

  ngOnInit(): void {
    if (this.matches.length == 0){
      this.appService.getHistory().subscribe(data => {
        this.fHistory = data;
        this.sHistory.push((this.fHistory.history));
        this.matches = this.sHistory[0];
        console.log(this.matches)
      });
    }

  }

}
