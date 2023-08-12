import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Player, Team } from 'src/app/response/response.interface'; 
import { PlayerService } from 'src/app/services/player/player.service';
import { TeamService } from 'src/app/services/team/team.service';

@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  styleUrls: ['./player-edit.component.css']
})
export class PlayerEditComponent implements OnInit {
  player: Player = {
    id: 0,
    name: '',
    dateOfBirth: '',
    nationality: '',
    position: '',
    achievements: '',
    status: 1,
    team: {
      id: 0,
      name: '',
      country: '',
      logoImage: '',
      status: 1,
      matches: []
    }
  };
  teams: Team[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');

        if (id) {
          this.playerService.getById(parseInt(id)).subscribe({
            next: (response) => {
              this.player = response;
            }
          });
        }
      }
    });

    this.teamService.getAll().subscribe({
      next: (response) => {
        this.teams = response
      }
    })
  }

  update() {
    this.playerService.update(this.player).subscribe({
      next: () => {
        this.router.navigate(['/players']);
      }
    });
  }
}
