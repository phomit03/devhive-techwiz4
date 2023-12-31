import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/response/category-response.interface';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { Product } from 'src/app/response/response.interface';
import { CategoryService } from 'src/app/services/category/category.service';
import { ProductService } from 'src/app/services/product/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent {
  messageResponse: MessageResponse = {
    message: 'Success'
  }

  productCreate: Product = {
    id: 0,
    name: '',
    image: '',
    quantity: '',
    price: 0,
    category: { id: 0, name: ''},
    status: 1
  }

  categories: Category[] = []

  constructor(
    private router: Router,
    private services: ProductService,
    private categoryService: CategoryService
  ) {}

  ngOnInit() {
    this.categoryService.getAll().subscribe({
      next: (response) => {
        this.categories = response;
      }
    })
  }

  create() {
    if (!this.productCreate.image) {
      Swal.fire({
        icon: 'error',
        title: 'Please select an image',
      });
      return;
    }

    this.services.create(this.productCreate).subscribe({
      next: (response) => {
        console.log(response);
        
      },
      error: () => {
        this.router.navigate(['/product'])
      }
    });
  }
}
