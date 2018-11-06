import { Component, OnInit } from '@angular/core';

import { UserService } from './user.service';
import { UserModel } from '../model/user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'], 
  providers: [UserService]
})
export class UserComponent implements OnInit {

  private users: Array<UserModel>

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.loadUser();
  }

  private loadUser(): void{
    console.log(this.userService.getUsers());
  }
}
