import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../../services/api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public loginFormGroup=new FormGroup({
    userName:new FormControl('',[Validators.required,Validators.minLength(4),Validators.maxLength(8)]),
    password:new FormControl('',[Validators.required,Validators.minLength(4),Validators.maxLength(8)])
    }

  )
  constructor(private apiService:ApiService,
              public router:Router) { }

  ngOnInit(): void {
  }

  submit() {
    if (this.loginFormGroup.valid) {
      const formData = this.loginFormGroup.value;
      // Process the form data, e.g., send it to the server
      console.log(formData);
      this.apiService.post("/your-cart/public/login", formData).subscribe((token: string) => {
        localStorage.setItem("token", token);
      });
      // Reset the form
      // this.loginFormGroup.reset();
    }
  }
}
