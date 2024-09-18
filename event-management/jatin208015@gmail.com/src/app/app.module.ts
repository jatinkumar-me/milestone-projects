import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideHttpClient } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { EventsService } from './services/events.service';
import { EventsModule } from './events/events.module';
import { AuthModule } from './auth/auth.module';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    EventsModule,
    AuthModule,
  ],
  providers: [provideHttpClient(), AuthService, EventsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
