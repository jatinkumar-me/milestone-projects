import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  isLoggedIn = false;
  username: string | null = null;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.user$.subscribe(user => {
      this.isLoggedIn = user !== null;
      this.username = user ? user.username : null;
    });
  }

  logout(): void {
    this.authService.logout();
  }
}
