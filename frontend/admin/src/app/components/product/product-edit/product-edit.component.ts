import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/response/response.interface'; 
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product = {
    id: 0,
    name: '',
    image: '',
    quantity: '',
    price: 0,
    category: {
      id: 0,
      name: '',
    },
    status: 1
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.productService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.product = response;
            }
          });
        }
      }
    });
  }

  update() {
    this.productService.update(this.product).subscribe({
      next: (response) => {
        this.router.navigate(['/products']);
      },
      error: (error) => {
      }
    });
  }
}
