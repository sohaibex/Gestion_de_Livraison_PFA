import { Component, OnInit } from '@angular/core';
import { JwtProjectService } from '../jwt-project.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  authRequest:any={
    "userName":"SuperAdmin",
    "password":"password"
  };

  response:any;

  constructor(private service:JwtProjectService) { }

  ngOnInit(): void {
    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest: any){

    let resp = this.service.generateToken(authRequest);
    resp.subscribe(data =>console.log("Token : "+data));
  }

  public accessApi(token: any){
    let resp=this.service.hello(token);
    resp.subscribe(data=>this.response=data);
      }
}
