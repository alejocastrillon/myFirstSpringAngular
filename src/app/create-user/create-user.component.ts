import { CreateUserService } from './create-user.service';
import { Component, OnInit } from '@angular/core';
import { UserModel } from '../model/user.model';

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

  constructor(private service: CreateUserService) {
    this.user = new UserModel();
   }

  ngOnInit() {
  }

  public saveorUpdate(): void{

  }
}
