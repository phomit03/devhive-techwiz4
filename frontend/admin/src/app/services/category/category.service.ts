import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/response/category-response.interface';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<Category[]> {
    return this.http.get<Category[]>(this.baseApiUrl + '/category/getAll')
  }

  getById(id: number) : Observable<Category> {
    return this.http.get<Category>(this.baseApiUrl + '/category/' + id);
  }

  create(categoryCreate: Category) {
    return this.http.post<MessageResponse>(this.baseApiUrl + '/category/create', categoryCreate);
  }

  update(categoryEdit: Category) {
    return this.http.post<Category>(this.baseApiUrl + '/category/' + categoryEdit.id, categoryEdit);
  }

  delete(id: number) {
    return this.http.delete<Category>(this.baseApiUrl + '/category/' + id);
  }
}
