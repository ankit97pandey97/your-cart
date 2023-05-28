import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./common/login/login.component";
import {RegistrationComponent} from "./common/registration/registration.component";
import {AuthenticationGuard} from "./authguard/authentication.guard";
import {HomeComponent} from "./main/home/home.component";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "sign-up", component: RegistrationComponent},
  {path: "home", component: HomeComponent, canActivate: [AuthenticationGuard]},
  {path:"",component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
