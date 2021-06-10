import { Component} from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-sort-table-goals',
  templateUrl: './sort-table-goals.component.html',
  styleUrls: ['./sort-table-goals.component.css']
})
export class SortTableGoalsComponent {

  clubs:any = [];
  fClubs: any = [];
  ftClubs: any =[];

  constructor(private appService: AppService) {
    this.appService.getGoals().subscribe(data => {
      this.fClubs = data;
      this.ftClubs.push((this.fClubs.fClubs));
      this.clubs = this.ftClubs[0];
      console.log(this.clubs)
    });
  }


}
