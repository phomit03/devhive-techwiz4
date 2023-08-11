import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Match } from 'src/app/response/response.interface';
import { MatchService } from 'src/app/services/match/match.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-match-list',
  templateUrl: './match-list.component.html',
  styleUrls: ['./match-list.component.css']
})
export class MatchListComponent {  
  matches: Match[] = [];
  constructor(private router: Router, private matchService: MatchService) {}
  ngOnInit() : void {
    this.matchService.getAll().subscribe({
      next: (response) => {
        this.matches = response;
      },
      error: (error) => {

      }
    })
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
          this.matchService.delete(id).subscribe({
            next: (response) => {
              
            },
            error: (error) => {

            }
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Access token not found!',
          })
        }
        Swal.fire(
          'Deleted!',
          'Deleting!',
          'success'
        )
        window.location.reload();
      }
    })
  }
}
