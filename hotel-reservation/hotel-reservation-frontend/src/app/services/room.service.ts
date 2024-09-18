import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private apiUrl = 'http://localhost:8090/rooms/availability';

  constructor(private http: HttpClient) { }

  formatDate(date: Date): string {
    return date.toISOString().split('T')[0];
  }

  checkRoomAvailability(searchParams: any): Observable<any[]> {
    const { startDate, endDate, roomType } = searchParams;
    const formattedStartDate = this.formatDate(startDate);
    const formattedEndDate = this.formatDate(endDate);
    return this.http.get<any[]>(`${this.apiUrl}?startDate=${formattedStartDate}&endDate=${formattedEndDate}&roomType=${roomType}`);
  }
}
