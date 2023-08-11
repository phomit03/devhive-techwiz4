import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { News } from 'src/app/response/response.interface';
import { NewsService } from 'src/app/services/news/news.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-news-create',
  templateUrl: './news-create.component.html',
  styleUrls: ['./news-create.component.css']
})
export class NewsCreateComponent {
  messageResponse: MessageResponse = {
    message: ''
  };

  newsCreate: News = {
    id: 0,
    title: '',
    image: '',
    description: ''
  };

  constructor(
    private router: Router,
    private newsService: NewsService
  ) {}

  create() {
    this.newsService.create(this.newsCreate).subscribe({
      next: () => {
        this.router.navigate(['/news']);
      },
      error: () => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
        });
      }
    });
  }
}
