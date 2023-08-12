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

  // create1(productDTO: Product, imageFile: File): Observable<HttpEvent<MessageResponse>> {
  //   const token = localStorage.getItem('access_token');
  //   const headers = new HttpHeaders({
  //     'Authorization': `Bearer ${token}`
  //   });
  //   const formData = new FormData();
  //   formData.append('name', productDTO.name);
  //   formData.append('quantity', productDTO.quantity);
  //   formData.append('price', productDTO.price.toString());
  //   formData.append('category', productDTO.category.id.toString());
  //   formData.append('status', productDTO.status.toString());
  //   formData.append('image', productDTO.image.toString());
  //   formData.append('imageFile', imageFile);

  //   const req = new HttpRequest('POST', `${this.baseApiUrl}/product/create`, formData, {
  //     headers,
  //     reportProgress: true,
  //     responseType: 'json'
  //   });

  //   return this.http.request(req);
  // }

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
    return this.http.get<Product>(this.baseApiUrl + '/product/' + id);
  }

  update(product: Product) {
    return this.http.post<Product>(this.baseApiUrl + '/product/' + product.id, product);
  }

  delete(id: number) {
    return this.http.delete<Product>(this.baseApiUrl + '/product/' + id);
  }
}
