import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Order } from 'src/app/response/response.interface';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-edit',
  templateUrl: './order-edit.component.html',
  styleUrls: ['./order-edit.component.css']
})
export class OrderEditComponent {
  order: Order = {
    id: 0,
    user: {
      id: 0,
      username: '',
      email: '',
      roles: [],
      accessToken: '',
      tokenType: ''
    },
    totalPrice: 0,
    status: 0,
    orderProducts: []
  }

  constructor (
    private route: ActivatedRoute, 
    private router: Router, 
    private orderService: OrderService
  ) {}

  ngOnInit() : void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.orderService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.order = response
            }
          })
        }
      }
    })
  }

  update() {
    this.orderService.update(this.order).subscribe({
      next: (response) => {
        this.router.navigate(['/order'])
      }
    })
  }
}

