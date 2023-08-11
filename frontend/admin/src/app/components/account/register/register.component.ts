import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterRequest } from 'src/app/requests/registerRequest.model';
import { AuthService } from 'src/app/services/auth/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerRequest: RegisterRequest = {
    username: '',
    email: '',
    role: ['user'],
    password: '',
    address: 'Empty',
    status: 0
  }

  constructor(private router: Router, private authService: AuthService) {}

  register() {
    this.authService.register(this.registerRequest).subscribe({
      next: (response) => {
        Swal.fire(
          'Good job!',
          response.message,
          'success'
        ).then(() => {
          this.router.navigate(['/login']);
        });
      }
    })
  }
}
