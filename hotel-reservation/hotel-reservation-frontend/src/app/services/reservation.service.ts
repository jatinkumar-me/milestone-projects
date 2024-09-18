import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = 'http://localhost:8090/reservations';

  constructor(private http: HttpClient) { }

  createReservation(reservation: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, reservation);
  }

  getUserReservations(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/users/${userId}`);
  }

  updateReservation(id: number, reservation: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, reservation);
  }

  cancelReservation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
