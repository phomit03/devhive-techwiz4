import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/requests/loginRequest.model';
import { AuthService } from 'src/app/services/auth/auth.service';
import Swal from 'sweetalert2';

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
        if (response.accessToken !== null && response.roles.includes('ROLE_ADMIN')) {
          localStorage.setItem('access_token', response.accessToken);
          localStorage.setItem('curr_user_role', response.roles.toString());
          console.log(localStorage.getItem('curr_user_role'));
          this.router.navigate(['/dashboard']);
        }
      },
      error: (error) => {
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
        });
      }

    })
  }
}
