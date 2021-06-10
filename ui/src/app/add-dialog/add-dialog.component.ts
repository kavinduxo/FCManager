import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent {

  clubs:any = [];
  matches: any = [];
  nMatches: any =[];

  constructor(private appService: AppService) {

  }

  public newMatch(): void {
    this.appService.createMatch().subscribe(data => {
      this.matches = data;
      this.nMatches.push((this.matches.matchAppend));
      this.clubs = this.nMatches[0];
    });
  }

}
