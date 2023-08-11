import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { News } from 'src/app/response/response.interface';
import { NewsService } from 'src/app/services/news/news.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent {  
  news: News[] = [];
  constructor(private router: Router, private newsService: NewsService) {}
  ngOnInit() : void {
    this.newsService.getAll().subscribe({
      next: (response) => {
        this.news = response;
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
          this.newsService.delete(id).subscribe({
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
