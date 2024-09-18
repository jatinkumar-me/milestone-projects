import { Component, OnInit } from '@angular/core';
import { Event, EventsService } from '../../services/events.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent implements OnInit {
  events: Event[] = [];
  userIdToInvite: number = 1; // Example user to invite

  constructor(private eventService: EventsService) { }

  ngOnInit(): void {
    this.loadEvents();
  }

  loadEvents() {
    this.eventService.getEvents().subscribe(data => {
      this.events = data;
    });
  }

  inviteUser(eventId: number) {
    this.eventService.inviteUser(eventId, this.userIdToInvite)
      .subscribe(() => {
        alert(`User ${this.userIdToInvite} has been invited to the event.`);
        this.loadEvents();
      });
  }
}
