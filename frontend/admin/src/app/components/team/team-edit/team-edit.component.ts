import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from 'src/app/response/response.interface'; 
import { TeamService } from 'src/app/services/team/team.service';

@Component({
  selector: 'app-team-edit',
  templateUrl: './team-edit.component.html',
  styleUrls: ['./team-edit.component.css']
})
export class TeamEditComponent implements OnInit {
  team: Team = {
    id: 0,
    name: '',
    country: '',
    logoImage: '',
    status: 1,
    matches: []
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private teamService: TeamService 
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.teamService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.team = response;
            }
          });
        }
      }
    });
  }

  update() {
    this.teamService.update(this.team).subscribe({
      next: () => {
        this.router.navigate(['/teams']);
      }
    });
  }
}
