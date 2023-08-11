import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageResponse } from 'src/app/response/messageResponse.interface';
import { Match } from 'src/app/response/response.interface';
import { MatchService } from 'src/app/services/match/match.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-match-create',
  templateUrl: './match-create.component.html',
  styleUrls: ['./match-create.component.css']
})

export class MatchCreateComponent {
  messageResponse: MessageResponse = {
    message: ''
  }

  matchCreate: Match = {
    id: 0,
    date: '',
    time: '',
    score: '',
    soccerInfo: '',
    status: 1,
    teams: []
  }

  constructor(
    private router: Router,
    private services: MatchService
  ) {}

  create() {
    this.services.create(this.matchCreate).subscribe({
      next: (response) => {
        this.router.navigate(['/math'])
      },
      error: (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
        });
      }
    })
  }
}