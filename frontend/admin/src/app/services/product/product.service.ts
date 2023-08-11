import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
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

  create(product: Product, imageFile: File) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    const formData = new FormData();
    formData.append('image', imageFile);
    formData.append('name', product.name);
    formData.append('quantity', product.quantity);
    formData.append('price', product.price.toString());
    formData.append('category', product.category.id.toString());
    formData.append('status', product.status.toString());
    const req = new HttpRequest('POST', `${this.baseApiUrl}/product/create`, formData, {
      headers,
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getAll() : Observable<Product[]> {
    return this.http.get<Product[]>(this.baseApiUrl + '/product/getAll')
  }

  getById(id: number) : Observable<Product> {
    return this.http.get<Product>(this.baseApiUrl + '/product/' + id);
  }

  update(product: Product) {
    return this.http.post<Product>(this.baseApiUrl + '/product/' + product.id, product);
  }

  delete(id: number) {
    return this.http.delete<Product>(this.baseApiUrl + '/product/' + id);
  }
}
