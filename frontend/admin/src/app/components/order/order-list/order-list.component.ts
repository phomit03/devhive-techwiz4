import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/response/response.interface';
import { OrderService } from 'src/app/services/order/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent {  
  orders: Order[] = [];
  constructor(private router: Router, private orderService: OrderService) {}
  ngOnInit() : void {
    this.orderService.getAll().subscribe({
      next: (response) => {
        this.orders = response;
      },
      error: (error) => {

      }
    })
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
          this.orderService.delete(id).subscribe({
            next: (response) => {
              
            },
            error: (error) => {

            }
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Access token not found!',
          })
        }
        Swal.fire(
          'Deleted!',
          'Deleting!',
          'success'
        )
        window.location.reload();
      }
    })
  }
}
