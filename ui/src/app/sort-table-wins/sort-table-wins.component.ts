import { Component} from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-sort-table-wins',
  templateUrl: './sort-table-wins.component.html',
  styleUrls: ['./sort-table-wins.component.css']
})
export class SortTableWinsComponent {

  clubs:any = [];
  fClubs: any = [];
  ftClubs: any =[];

  constructor(private appService: AppService) {
    this.appService.getWins().subscribe(data => {
      this.fClubs = data;
      this.ftClubs.push((this.fClubs.fClubs));
      this.clubs = this.ftClubs[0];
      console.log(this.clubs)
    });
  }
}
