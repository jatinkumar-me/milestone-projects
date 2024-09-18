import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrl: './event-details.component.css'
})
export class EventDetailsComponent implements OnInit {
  @Input() event: any;
  @Input() userIdToInvide: number = 1;
  @Output() invite = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  inviteUser() {
    this.invite.emit(this.userIdToInvide);
  }
}
