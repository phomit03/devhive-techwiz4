import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<Match[]>(this.baseApiUrl + '/match/getAll', {headers})
  }

  getById(id: number) : Observable<Match> {
    return this.http.get<Match>(this.baseApiUrl + '/match/' + id);
  }

  create(matchCreate: Match) {
    return this.http.post<Match>(this.baseApiUrl + '/match/create', matchCreate);
  }

  update(matchEdit: Match) {
    return this.http.post<Match>(this.baseApiUrl + '/match/' + matchEdit.id, matchEdit);
  }

  delete(id: number) {
    return this.http.delete<Match>(this.baseApiUrl + '/match/' + id);
  }
}
