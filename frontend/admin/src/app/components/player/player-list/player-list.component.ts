import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Player } from 'src/app/response/response.interface';
import { PlayerService } from 'src/app/services/player/player.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css'],
  providers: [DatePipe]
})
export class PlayerListComponent implements OnInit {  
  players: Player[] = [];
  
  constructor(private router: Router, private playerService: PlayerService) {}

  ngOnInit(): void {
    this.playerService.getAll().subscribe({
      next: (response) => {
        this.players = response;
      },
      error: (error) => {
        // Handle error
      }
    });
  }

  delete(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        const token = localStorage.getItem('access_token');
        if (token !== null) {
          this.playerService.delete(id).subscribe({
            next: (response) => {
              // Handle success
            },
            error: (error) => {
              // Handle error
            }
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Access token not found!',
          });
        }
        Swal.fire(
          'Deleted!',
          'Player has been deleted.',
          'success'
        );
        window.location.reload();
      }
    });
  }
}
