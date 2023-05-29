import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  public registrationGroup:FormGroup= this.fb.group({
    firstName:new FormControl(""),
    userName:new FormControl(""),
    lastName:new FormControl(""),
    password:new FormControl(""),
    roles:this.fb.group({
      role:new FormControl("BUYER")
    }),
    userDetails:this.fb.group({
      street:new FormControl(""),
      colony:new FormControl(""),
      city:new FormControl(""),
      state:new FormControl(""),
      pinCode:new FormControl(""),
      country:new FormControl("")
    })
  })
  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.registrationGroup.value)
  }
}
