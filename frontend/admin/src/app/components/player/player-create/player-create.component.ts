import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Player, Team } from 'src/app/response/response.interface'; 
import { PlayerService } from 'src/app/services/player/player.service';
import { TeamService } from 'src/app/services/team/team.service';

@Component({
  selector: 'app-player-create',
  templateUrl: './player-create.component.html',
  styleUrls: ['./player-create.component.css']
})
export class PlayerCreateComponent implements OnInit {
  newPlayer: Player = {
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
    private router: Router,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {}

  ngOnInit(): void {
    this.teamService.getAll().subscribe({
      next: (response) => {
        this.teams = response
      }
    })
  }

  create() {
    this.playerService.create(this.newPlayer).subscribe({
      next: () => {
        this.router.navigate(['/players']);
      }
    });
  }
}
