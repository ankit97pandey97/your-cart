import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../interfaces/i-user";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userData?:IUser;
  constructor() { }

  public getUser():IUser|undefined{
      return this.userData;
  }
  public setUser(user:IUser|undefined){
    this.userData = user;
  }

}
