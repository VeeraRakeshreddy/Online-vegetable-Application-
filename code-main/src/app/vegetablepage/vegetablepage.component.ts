import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VegetablesService } from '../vegetables.service';
import { Vegetable } from '../vegetable';


@Component({
  selector: 'app-vegetablepage',
  templateUrl: './vegetablepage.component.html',
  styleUrls: ['./vegetablepage.component.css']
})
export class VegetablepageComponent implements OnInit {

  vegetables: any;
  arr:any;

  
    constructor(private vegetableService: VegetablesService, 
      private router: Router) { }
  
    ngOnInit(): void {
      this.getVegetables();
    }
  
    private getVegetables(){
      this.vegetableService.getAllvegetables().subscribe(data => {
        this.vegetables = data;
      });
    }
  
    vegetableDetails(id: any){
      // this.vegService.getVegetableById(id);
      this.router.navigate(['show',id]);
    }
  
    updateVegetable(id: number){
      this.router.navigate(['admin',id]);
    }
    
    deleteVegetable(id: number){
      this.vegetableService.deleteVegetable(id).subscribe( data => {
        console.log(data);
        this.getVegetables();
      })
    }
    
   
    
    }
  


