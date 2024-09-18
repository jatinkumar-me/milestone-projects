import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventListComponent } from './events/event-list/event-list.component';
import { EventDetailsComponent } from './events/event-details/event-details.component';
import { EventRegisterComponent } from './events/event-register/event-register.component';
import { LoginComponent } from './auth/login/login.component';

const routes: Routes = [
  { path: 'events', component: EventListComponent },
  { path: 'events/:id', component: EventDetailsComponent },
  { path: 'register', component: EventRegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/events', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
