import { HttpClient } from '@angular/common/http';
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
    return this.http.get<News[]>(this.baseApiUrl + '/news/getAll');
  }

  getById(id: number) : Observable<News> {
    return this.http.get<News>(this.baseApiUrl + '/news/' + id);
  }

  create(newsCreate: News) {
    return this.http.post<News>(this.baseApiUrl + '/news/create', newsCreate);
  }

  update(newsEdit: News) {
    return this.http.post<News>(this.baseApiUrl + '/news/' + newsEdit.id, newsEdit);
  }

  delete(id: number) {
    return this.http.delete<News>(this.baseApiUrl + '/news/' + id);
  }
}
