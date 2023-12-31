import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/response/response.interface'; // Thay thế đường dẫn tới interface Product
import { ProductService } from 'src/app/services/product/product.service'; // Thay thế đường dẫn tới ProductService
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {  
  products: Product[] = [];
  
  constructor(private router: Router, private productService: ProductService) {} // Thay thế ProductService

  ngOnInit(): void {
    this.productService.getAll().subscribe({
      next: (response) => {
        this.products = response;
      },
      error: (error) => {
        // Handle error
      }
    });
  }

  delete(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        const token = localStorage.getItem('access_token');
        if (token !== null) {
          this.productService.delete(id).subscribe({
            next: (response) => {
              // Handle success
            },
            error: (error) => {
              // Handle error
            }
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Access token not found!',
          });
        }
        Swal.fire(
          'Deleted!',
          'Product has been deleted.',
          'success'
        );
        window.location.reload();
      }
    });
  }
}
