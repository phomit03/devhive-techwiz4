import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Player } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<Player[]> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<Player[]>(this.baseApiUrl + '/player/getAll', {headers})
  }

  getById(id: number) : Observable<Player> {
    return this.http.get<Player>(this.baseApiUrl + '/player/' + id);
  }

  create(playerCreate: Player) {
    return this.http.post<Player>(this.baseApiUrl + '/player/create', playerCreate);
  }

  update(playerEdit: Player) {
    return this.http.post<Player>(this.baseApiUrl + '/player/' + playerEdit.id, playerEdit);
  }

  delete(id: number) {
    return this.http.delete<Player>(this.baseApiUrl + '/player/' + id);
  }
}
