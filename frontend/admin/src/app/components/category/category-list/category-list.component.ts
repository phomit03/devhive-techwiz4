import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/response/category-response.interface';
import { CategoryService } from 'src/app/services/category/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {  
  categories: Category[] = [];
  constructor(private router: Router, private categoryService: CategoryService) {}
  ngOnInit() : void {
    this.categoryService.getAll().subscribe({
      next: (response) => {
        this.categories = response;
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
          this.categoryService.delete(id).subscribe({
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
