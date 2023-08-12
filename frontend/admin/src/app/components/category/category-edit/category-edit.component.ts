import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Category } from 'src/app/response/category-response.interface';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent {
  category: Category = {
    id: 0,
    name: '',
  }

  constructor (
    private route: ActivatedRoute, 
    private router: Router, 
    private categoryService: CategoryService
  ) {}

  ngOnInit() : void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.categoryService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.category = response
            }
          })
        }
      }
    })
  }

  update() {
    this.categoryService.update(this.category).subscribe({
      next: (response) => {
        this.router.navigate(['/category'])
      }
    })
  }
}
