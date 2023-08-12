import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { News } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<News[]> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<News[]>(this.baseApiUrl + '/new/getAll', {headers})
  }

  getById(id: number) : Observable<News> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<News>(this.baseApiUrl + '/new/' + id, {headers});
  }

  create(newsCreate: News) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<News>(this.baseApiUrl + '/new/create', newsCreate, {headers});
  }

  update(newsEdit: News) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<News>(this.baseApiUrl + '/new/' + newsEdit.id, newsEdit, {headers});
  }

  delete(id: number) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<News>(this.baseApiUrl + '/new/' + id, {headers});
  }
}
