import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/response/category-response.interface';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { CategoryService } from 'src/app/services/category/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent {
  messageResponse: MessageResponse = {
    message: ''
  }

  categoryCreate: Category = {
    id: 0,
    name: '',
  }

  constructor(
    private router: Router,
    private services: CategoryService
  ) {}

  create() {
    this.services.create(this.categoryCreate).subscribe({
      next: (response) => {
        this.router.navigate(['/category'])
      },
      error: (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
        });
      }
    })
  }
}
