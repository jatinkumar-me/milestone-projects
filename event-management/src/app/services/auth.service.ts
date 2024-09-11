import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private apiUrl = 'http://localhost:3000/users';
  private userSubject = new BehaviorSubject<User | null>(null);
  user$ = this.userSubject.asObservable();

  constructor(private http: HttpClient) {
    const user = this.loadUserFromStorage();
    this.userSubject.next(user);
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.get<User[]>(`${this.apiUrl}?username=${username}&password=${password}`)
      .pipe(
        map(users => {
          if (users.length > 0) {
            const user = users[0];
            this.setUser(user);
            return true;
          }
          return false;
        })
      );
  }

  register(username: string, password: string): Observable<User> {
    const newUser = { username, password };
    return this.http.post<User>(`${this.apiUrl}/register`, newUser); // Ensure this matches your API
  }

  private setUser(user: User): void {
    this.userSubject.next(user);
    this.saveUserToStorage(user);
  }

  private loadUserFromStorage(): User | null {
    const userJson = localStorage.getItem('user');
    return userJson ? JSON.parse(userJson) : null;
  }

  private saveUserToStorage(user: User): void {
    localStorage.setItem('user', JSON.stringify(user));
  }

  isLoggedIn(): boolean {
    return this.userSubject.getValue() !== null;
  }

  logout(): void {
    this.userSubject.next(null);
    localStorage.removeItem('user');
  }
}

export interface User {
  id: number,
  username: string,
  password: string
}
