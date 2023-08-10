import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  constructor(private router: Router) { }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const userRole = parseInt(localStorage.getItem('curr_user_role') ?? 'ROLE_USER');
    if (localStorage.getItem('access_token') && userRole == 0) {  
      return true;  
  }  
  this.router.navigate(['/login']);  
  return false;  
  }

}
