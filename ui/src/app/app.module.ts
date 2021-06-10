import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';
import { AngularMaterialModule } from './material/material.module';
import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { PointTableComponent } from './point-table/point-table.component';
import { AppRoutingModule } from './app-routing.module';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { SortDirective } from './directive/sort.directive';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import { HistoryTableComponent } from './history-table/history-table.component';
import { SortTableWinsComponent } from './sort-table-wins/sort-table-wins.component';
import { SortTableGoalsComponent } from './sort-table-goals/sort-table-goals.component';
import {MatDialogModule} from "@angular/material/dialog";
import { AddDialogComponent } from './add-dialog/add-dialog.component';
import { SearchHistoryComponent } from './search-history/search-history.component';

const routes: Routes = [
  {
    path: 'java',
    component: RouteExampleComponent,
    data: { technology: 'Java' }
  },
  {
    path: 'play',
    component: RouteExampleComponent,
    data: { technology: 'Play' }
  },
  {
    path: 'angular',
    component: RouteExampleComponent,
    data: { technology: 'Angular' }
  },
  {
    path: '**',
    redirectTo: '/pointTable',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    PointTableComponent,
    MainMenuComponent,
    SortDirective,
    HistoryTableComponent,
    SortTableWinsComponent,
    SortTableGoalsComponent,
    AddDialogComponent,
    SearchHistoryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    AngularMaterialModule,
    MatDialogModule
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  entryComponents: [
    AddDialogComponent
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {
}
