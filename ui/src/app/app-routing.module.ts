import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PointTableComponent } from "./point-table/point-table.component";
import {RouterModule, Routes} from "@angular/router";
import {SortTableWinsComponent} from "./sort-table-wins/sort-table-wins.component";
import {SortTableGoalsComponent} from "./sort-table-goals/sort-table-goals.component";
import {HistoryTableComponent} from "./history-table/history-table.component";
import {SearchHistoryComponent} from "./search-history/search-history.component";


const routes: Routes = [
  {path: 'pointTable', component: PointTableComponent},
  {path: 'sortWin', component: SortTableWinsComponent},
  {path: 'sortGoal', component: SortTableGoalsComponent},
  {path: 'history', component: HistoryTableComponent},
  {path: 'searchHistory', component: SearchHistoryComponent},
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  providers:[]
})
export class AppRoutingModule { }
