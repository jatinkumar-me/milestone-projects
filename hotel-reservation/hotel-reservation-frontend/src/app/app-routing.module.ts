import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationFormComponent } from './components/reservation-form/reservation-form.component';
import { RoomAvailabilityComponent } from './components/room-availability/room-availability.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';

const routes: Routes = [
  { path: 'book', component: ReservationFormComponent },
  { path: 'availability', component: RoomAvailabilityComponent },
  { path: 'dashboard', component: UserDashboardComponent },
  { path: '', redirectTo: '/book', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
