import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
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

  create(productDTO: Product): Observable<MessageResponse> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
  
    return this.http.post<MessageResponse>(`${this.baseApiUrl}/product/create`, productDTO, { headers });
  }

  getAll() : Observable<Product[]> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });

    return this.http.get<Product[]>(this.baseApiUrl + '/product/getAll', {headers})
  }

  getById(id: number) : Observable<Product> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.get<Product>(this.baseApiUrl + '/product/' + id, {headers});
  }

  update(product: Product) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.post<Product>(this.baseApiUrl + '/product/' + product.id, product, {headers});
  }

  delete(id: number) {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.delete<Product>(this.baseApiUrl + '/product/' + id, {headers});
  }
}
