import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/requests/loginRequest.model';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginRequest: LoginRequest = {
    username: "",
    password: ""
  }

  constructor(private router: Router, private authServices: AuthService) {
    if(authServices.loggedIn) {
      router.navigate(['/dashboard']);
    }

  }

  login() {
    this.authServices.login(this.loginRequest).subscribe({
      next: (response) => {
        console.log(response);
      }
    })
  }
}
