import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {
  private clubsUrl = '/api/clubs';
  private winUrl = '/api/wins';
  private goalUrl = '/api/goals';
  private histUrl = '/api/history';
  private newMatchUrl = '/api/newMatch '

  constructor(private httpClient: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */
  public getClubs(){
    return this.httpClient.get(this.clubsUrl);
  }
  public getWins(){
    return this.httpClient.get(this.winUrl);
  }
  public getGoals(){
    return this.httpClient.get(this.goalUrl);
  }
  public getHistory(){
    return this.httpClient.get(this.histUrl);
  }
  /**
   * Makes a http post request to send some data to backend & get response.
   */
  public createMatch(): Observable<any> {
    return this.httpClient.post(this.newMatchUrl, {});
  }
}
