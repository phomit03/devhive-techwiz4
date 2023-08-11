import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from 'src/app/response/response.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  getAll() : Observable<Order[]> {
    const token = localStorage.getItem('access_token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<Order[]>(this.baseApiUrl + '/order/getAll', {headers})
  }

  getById(id: number) : Observable<Order> {
    return this.http.get<Order>(this.baseApiUrl + '/order/' + id);
  }

  create(orderCreate: Order) {
    return this.http.post<Order>(this.baseApiUrl + '/order/create', orderCreate);
  }

  update(orderEdit: Order) {
    return this.http.post<Order>(this.baseApiUrl + '/order/' + orderEdit.id, orderEdit);
  }

  delete(id: number) {
    return this.http.delete<Order>(this.baseApiUrl + '/order/' + id);
  }
}
