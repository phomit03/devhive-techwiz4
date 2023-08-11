import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from 'src/app/response/response.interface';
import { TeamService } from 'src/app/services/team/team.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-team-create',
  templateUrl: './team-create.component.html',
  styleUrls: ['./team-create.component.css']
})
export class TeamCreateComponent {
  teamCreate: Team = {
    id: 0,
    name: '',
    country: '',
    logoImage: '',
    status: 1,
    matches: []
  };

  constructor(
    private router: Router,
    private teamService: TeamService
  ) {}

  create() {
    this.teamService.create(this.teamCreate).subscribe({
      next: () => {
        this.router.navigate(['/teams']);
      },
      error: () => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Failed to create team.',
        });
      }
    });
  }
}
