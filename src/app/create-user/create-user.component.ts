import { UserComponent } from './../user/user.component';
import { RestResponse } from './../model/restResponse';
import { CreateUserService } from './create-user.service';
import { Component, OnInit } from '@angular/core';
import { UserModel } from '../model/user.model';
import { OK, NOT_ACCEPTABLE } from "../model/httpStatus";
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss'], 
  providers: [CreateUserService]
})
export class CreateUserComponent implements OnInit {

  private user: UserModel;
  private isValid: boolean = true;
  private message: string = "";
  private showMessage: boolean = false;
  private titleForm: string = "";

  constructor(private service: CreateUserService, private router: Router) {
    
    if (sessionStorage.getItem('user')) {
      this.user = JSON.parse(sessionStorage.getItem('user'));
      this.titleForm = "Editar Usuario";
    } else {
      this.user = new UserModel();
      this.titleForm = "Crear usuario";
    }
   }

  ngOnInit() {
  }

  public validateUser(): boolean{
    if (!this.user.firstName) {
      return false;
    } else if (!this.user.firstSurname) {
      return false;
    } else if (!this.user.address) {
      return false;
    }
    return true;
  }

  public saveorUpdate(): void{
    console.log(this.user);
    this.showMessage = true;
    if (this.validateUser()) {
      this.service.saveorUpdate(this.user).subscribe(res => {
        console.log(res);
        this.message = res.message;
        if (res.responseCode == OK) {
          this.router.navigate(['/userComponent']);
          this.isValid = true;
        }
      });
    } else {
      this.isValid = false;
      this.message = "Es necesario ingresar todos los datos";
    }
  }
}
