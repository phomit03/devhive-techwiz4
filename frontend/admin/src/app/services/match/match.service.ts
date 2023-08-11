import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<Match[]> {
    return this.http.get<Match[]>(this.baseApiUrl + '/match/getAll');
  }

  getById(id: number) : Observable<Match> {
    return this.http.get<Match>(this.baseApiUrl + '/match/' + id);
  }

  create() {

  }
}
