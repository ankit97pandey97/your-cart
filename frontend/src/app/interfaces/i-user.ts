import {IUserDetails} from "./i-user-details";

export interface IUser {
  id:number;

  userName:string;

  firstName:string;

  lastName:string;

  password:string;

  userDetails:IUserDetails;
}
