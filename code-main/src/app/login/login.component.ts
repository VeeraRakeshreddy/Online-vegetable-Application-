import { Component, OnInit } from '@angular/core';
import { AppService } from '../appservice.service';
import { Login } from '../login';
import { Loginresponse } from '../loginresponse';
import { Router } from '@angular/router';
import { RegistrationComponent } from '../registration/registration.component';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  data:Login = new Login('','');
  display:string=""
  responseStatus:Loginresponse=<Loginresponse>{}
  errorResponse:any;

  constructor(private router:Router,private appService:AppService) { }
formSubmit(){
  this.data.saveData(this.data);
  
 
  console.log(this.data);
  this.appService.doLoginAction(this.data).subscribe((data)=>{
    this.responseStatus=data;
    localStorage.setItem('all_users',JSON.stringify(data));
    if(this.responseStatus.username != 'invalid'){
      console.log(localStorage.getItem('all_users'))
      this.router.navigate([`${'home'}`]);
    }
    
   
  }
  ,
  error=>{
    this.errorResponse=error;
    alert(this.errorResponse.error.errorMsg + "PLEASE REGISTER");
    
  }
  );
 

}
formforadmin(){
  this.data.saveData(this.data);
  
 
  console.log(this.data);
  this.appService.doLoginActionadmin(this.data).subscribe((data)=>{
    this.responseStatus=data;
    localStorage.setItem('all_users',JSON.stringify(data));
    if(this.responseStatus.username != 'invalid'){
      console.log(localStorage.getItem('all_users'))
      this.router.navigate([`${'update'}`]);
    }
    
   
  }
  ,
  error=>{
    this.errorResponse=error;
    alert(this.errorResponse.error.errorMsg + "PLEASE REGISTER");
    
  }
  );
 

}
form()
{
  this.router.navigate([`${'Register'}`]);
}
closeForm(){
  this.display="Please login";
}
openForm(){
  this.display="block";
}


  ngOnInit(): void {
  }

}
function formSubmit1() {
  throw new Error('Function not implemented.');
}

