import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService, User } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const user: User = this.loginForm.value;
      this.authService.login(user.username, user.password).subscribe({
        next: (isLoginSuccess) => {
          if (!isLoginSuccess) {
            alert('Login failed');
            return;
          }
          alert('Login successful!');
          this.loginForm.reset();
        },
        error: error => {
          alert('Login failed: ' + error.message);
        }
      });
    } else {
      alert('Please fill out all required fields.');
    }
  }
}
