import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RoomService } from '../../services/room.service';

@Component({
  selector: 'app-room-availability',
  templateUrl: './room-availability.component.html',
  styleUrl: './room-availability.component.css'
})
export class RoomAvailabilityComponent {
  availabilityForm: FormGroup;
  availableRooms: any[] = [];

  constructor(private fb: FormBuilder, private roomService: RoomService) {
    this.availabilityForm = this.fb.group({
      roomType: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required]
    });
  }

  onSearch(): void {
    if (this.availabilityForm.valid) {
      const searchParams = this.availabilityForm.value;
      this.roomService.checkRoomAvailability(searchParams).subscribe((rooms: any) => {
        this.availableRooms = rooms;
      });
    }
  }
}
