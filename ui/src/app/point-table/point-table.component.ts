import { Component} from '@angular/core';
import {AppService} from "../app.service";
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from '../material/material.module';
import {AddDialogComponent} from "../add-dialog/add-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.css']
})
export class PointTableComponent {

  clubs:any = [];
  fClubs: any = [];
  ftClubs: any =[];
  displayedColumns: string[] = ['name', 'numberOfMatches', 'numberOfWins', 'numberOfDrawn', 'points'];
  dataSource = this.clubs;

  constructor(private appService: AppService, public dialog: MatDialog) {
    this.appService.getClubs().subscribe(data => {
      this.fClubs = data;
      this.ftClubs.push((this.fClubs.fClubs));
      this.clubs = this.ftClubs[0];
      console.log(this.clubs)
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddDialogComponent, {

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
