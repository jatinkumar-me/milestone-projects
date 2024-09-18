import { Component } from '@angular/core';
import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrl: './user-dashboard.component.css'
})
export class UserDashboardComponent {
  reservations: any[] = [];

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.loadReservations();
  }

  loadReservations(): void {
    this.reservationService.getUserReservations(1).subscribe((reservations: any) => {
      this.reservations = reservations;
    });
  }

  onView(id: number): void {
  }

  onUpdate(id: number): void {
  }

  onCancel(id: number): void {
    this.reservationService.cancelReservation(id).subscribe(() => {
      this.loadReservations();
    });
  }
}
