import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Match } from 'src/app/response/response.interface';
import { MatchService } from 'src/app/services/match/match.service';

@Component({
  selector: 'app-match-edit',
  templateUrl: './match-edit.component.html',
  styleUrls: ['./match-edit.component.css']
})
export class MatchEditComponent {
  match: Match = {
    id: 0,
    date: '',
    time: '',
    score: '',
    soccerInfo: '',
    status: 1,
    teams: []
  }

  constructor (
    private route: ActivatedRoute, 
    private router: Router, 
    private matchService: MatchService
  ) {}

  ngOnInit() : void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.matchService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.match = response
            }
          })
        }
      }
    })
  }

  update() {
    this.matchService.update(this.match).subscribe({
      next: (response) => {
        this.router.navigate(['/match'])
      }
    })
  }
}