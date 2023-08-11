import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from 'src/app/response/response.interface';
import { NewsService } from 'src/app/services/news/news.service';

@Component({
  selector: 'app-news-edit',
  templateUrl: './news-edit.component.html',
  styleUrls: ['./news-edit.component.css']
})
export class NewsEditComponent {
  news: News = {
    id: 0,
    title: '',
    image: '',
    description: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private newsService: NewsService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.newsService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.news = response;
            }
          });
        }
      }
    });
  }

  update() {
    this.newsService.update(this.news).subscribe({
      next: () => {
        this.router.navigate(['/news']);
      }
    });
  }
}
