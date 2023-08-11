import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { Product } from 'src/app/response/response.interface';
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
    category: { id: 0, name: '', products: [] },
    status: 0
  }

  constructor(
    private router: Router,
    private services: ProductService
  ) {}

  create() {
    this.services.create(this.productCreate).subscribe({
      next: (response) => {
        this.router.navigate(['/product'])
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
