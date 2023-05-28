import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import {HomeComponent} from "./home/home.component";
import {SettingsComponent} from "./settings/settings.component";


@NgModule({
  declarations: [
    HomeComponent,
    SettingsComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule
  ]
})
export class MainModule { }
