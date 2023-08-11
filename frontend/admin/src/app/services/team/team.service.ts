import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Player, Team } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<Team[]> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<Team[]>(this.baseApiUrl + '/team/getAll', {headers})
  }

  getById(id: number) : Observable<Team> {
    return this.http.get<Team>(this.baseApiUrl + '/team/' + id);
  }

  create(teamCreate: Team) {
    return this.http.post<Team>(this.baseApiUrl + '/team/create', teamCreate);
  }

  update(teamEdit: Team) {
    return this.http.post<Team>(this.baseApiUrl + '/team/' + teamEdit.id, teamEdit);
  }

  delete(id: number) {
    return this.http.delete<Team>(this.baseApiUrl + '/team/' + id);
  }
}
