import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Player, Team } from 'src/app/response/response.interface'; 
import { PlayerService } from 'src/app/services/player/player.service';

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

  constructor(
    private router: Router,
    private playerService: PlayerService
  ) {}

  ngOnInit(): void {}

  create() {
    this.playerService.create(this.newPlayer).subscribe({
      next: () => {
        this.router.navigate(['/players']);
      }
    });
  }
}
