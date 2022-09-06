import { Component, OnInit } from '@angular/core';
import { AppService } from '../appservice.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { Register } from '../register';
import { Registerresponse } from '../registerresponse';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  data1:Register = new Register('','','','');
  display:string=""
  responseStatus:Registerresponse=<Registerresponse>{}
  errorResponse:any;

  

  constructor(private router:Router,private appService:AppService) { } 
  ngOnInit(): void {
  }
  formSubmit1(){
    this.data1.saveData(this.data1);
  
 
  console.log(this.data1);
  this.appService.doRegistration(this.data1).subscribe((data1)=>{
    this.responseStatus=data1;
    localStorage.setItem('username',JSON.stringify(data1.username));
    localStorage.setItem('password',JSON.stringify(data1.password));
    
    localStorage.setItem('role',JSON.stringify(data1.role));
    }

    
   
  
  ,
  error=>{
    this.errorResponse=error;
    alert(this.errorResponse.error.errorMsg + "unknown");
    
  }
  );
 
 
 }

}
