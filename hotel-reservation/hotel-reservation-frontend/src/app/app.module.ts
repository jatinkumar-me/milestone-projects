import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReservationListComponent } from './components/reservation-list/reservation-list.component';
import { ReservationFormComponent } from './components/reservation-form/reservation-form.component';
import { RoomAvailabilityComponent } from './components/room-availability/room-availability.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
  declarations: [
    AppComponent,
    ReservationListComponent,
    ReservationFormComponent,
    RoomAvailabilityComponent,
    UserDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCardModule,
    MatListModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule
  ],
  providers: [provideHttpClient(), provideAnimationsAsync()],
  bootstrap: [AppComponent]
})
export class AppModule { }
