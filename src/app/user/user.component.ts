
import { Router } from '@angular/router';
import { UserModel } from './../model/user.model';
import { Component, OnInit } from '@angular/core';

import { UserService } from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'], 
  providers: [UserService]
})
export class UserComponent implements OnInit {

  private users: Array<UserModel>;
  private userDelete: UserModel;

  constructor(private userService: UserService, private route: Router) { }

  ngOnInit() {
    this.loadUser();
    sessionStorage.clear();
  }

  private loadUser(): void{
    this.userService.getUsers().subscribe(res => {
      this.users = res;
      console.log(res);
    });
  }

  public edit(user:UserModel):void{
    sessionStorage.setItem('user', JSON.stringify(user));
    this.route.navigate(['/createUserComponent']);
  }

  public delete():void{
    this.userService.deleteUser(this.userDelete).subscribe( res => {
      console.log(res);
      if (res.responseCode == 202) {  
        this.route.navigate(['/userComponent']);
      }
    });
    this.userDelete = new UserModel();
    this.loadUser();
  }

  public selectedUserDelete(user:UserModel):void{
    this.userDelete = user;
  }
}
