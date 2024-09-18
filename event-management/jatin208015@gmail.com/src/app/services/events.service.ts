import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, switchMap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  private apiUrl = 'http://localhost:3000/events';

  constructor(private http: HttpClient) { }

  getEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.apiUrl);
  }

  createEvent(event: Event): Observable<Event> {
    return this.http.post<any>(this.apiUrl, event);
  }

  getEventById(id: number): Observable<Event | undefined> {
    return this.http.get<Event>(`${this.apiUrl}/${id}`);
  }

  getInvitedUsers(eventId: number): Observable<number[]> {
    return this.http.get<Event>(`${this.apiUrl}/${eventId}`)
      .pipe(map(event => event.guests));
  }

  inviteUser(eventId: number, userId: number): Observable<Event> {
    return this.getEventById(eventId).pipe(
      switchMap(event => {
        if (event && !event.guests.includes(userId)) {
          event.guests.push(userId);
          return this.http.put<Event>(`${this.apiUrl}/${eventId}`, event);
        }
        return throwError(() => new Error('User is already invited or event not found'));
      })
    );
  }
}

export interface Event {
  id: number;
  name: string;
  date: string;
  location: string;
  description: string;
  guests: number[];
}
