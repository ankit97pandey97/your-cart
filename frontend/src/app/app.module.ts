import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedComponent } from './shared/shared.component';
import { LoginComponent } from './common/login/login.component';
import { RegistrationComponent } from './common/registration/registration.component';
import { HomeComponent } from './main/home/home.component';
import { SettingsComponent } from './main/settings/settings.component';
import { NavBarComponent } from './common/nav-bar/nav-bar.component';
import { MainComponent } from './main/main.component';
import {MainModule} from "./main/main.module";
import {CommonModule} from "@angular/common";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    NavBarComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModule,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
