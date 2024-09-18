import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrl: './reservation-form.component.css',
})
export class ReservationFormComponent {
  bookingForm: FormGroup;

  constructor(private fb: FormBuilder, private reservationService: ReservationService) {
    this.bookingForm = this.fb.group({
      roomType: ['', Validators.required],
      checkInDate: ['', Validators.required],
      checkOutDate: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.bookingForm.valid) {
      const bookingDetails = this.bookingForm.value;
      bookingDetails.userId = 1;
      this.reservationService.createReservation(bookingDetails).subscribe(response => {
        console.log('Room booked successfully', response);
      });
    }
  }
}
