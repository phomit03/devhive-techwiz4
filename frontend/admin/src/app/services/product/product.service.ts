import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { Product } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  create(categoryCreate: Product) {
    return this.http.post<MessageResponse>(this.baseApiUrl + '/product/create', categoryCreate);
  }

  getAll() : Observable<Product[]> {
    return this.http.get<Product[]>(this.baseApiUrl + '/product/getAll')
  }

  getById(id: number) : Observable<Product> {
    return this.http.get<Product>(this.baseApiUrl + '/product/' + id);
  }

  update(categoryEdit: Product) {
    return this.http.post<Product>(this.baseApiUrl + '/product/' + categoryEdit.id, categoryEdit);
  }

  delete(id: number) {
    return this.http.delete<Product>(this.baseApiUrl + '/product/' + id);
  }
}
