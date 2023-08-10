import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from 'src/app/requests/loginRequest.model';
import { RegisterRequest } from 'src/app/requests/registerRequest.model';
import { UserResponse } from 'src/app/response/login-response.interface';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { environment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseApiUrl: string = environment.baseApiUrl;
  constructor(private http: HttpClient) { }

  login(loginRequest: LoginRequest) {
    return this.http.post<UserResponse>(this.baseApiUrl + '/auth/signin' , loginRequest);
  }

  logout() {  
    localStorage.removeItem('access_token');  
  }

  public get loggedIn(): boolean {  
    return (localStorage.getItem('access_token') !== null);  
  }

  register(registerRequest: RegisterRequest) {
    return this.http.post<MessageResponse>(this.baseApiUrl + '/auth/signup' , registerRequest);
  }
}