import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EventsService } from '../../services/events.service';

@Component({
  selector: 'app-event-register',
  templateUrl: './event-register.component.html',
  styleUrl: './event-register.component.css'
})
export class EventRegisterComponent {
  eventForm: FormGroup;

  constructor(private fb: FormBuilder, private eventService: EventsService) {
    this.eventForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      date: ['', Validators.required],
      location: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.eventForm.valid) {
      this.eventService.createEvent(this.eventForm.value).subscribe(
        {
          next: () => {
            alert('Event created successfully!');
            this.eventForm.reset();
          },
          error: error => {
            alert('Failed to create event: ' + error);
          }
        });
    } else {
      alert('Please fill out all required fields.');
    }
  }
}
