import { Component, OnInit } from '@angular/core';
import { Vegetable } from '../vegetable';
import { VegetablesService } from '../vegetables.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-admimpage',
  templateUrl: './admimpage.component.html',
  styleUrls: ['./admimpage.component.css']
})
export class AdmimpageComponent implements OnInit {

  id: any
    vegetable: any;
    constructor(private vegetableService: VegetablesService,
      private route: ActivatedRoute,
      private router: Router) { 
      
      }
  
    ngOnInit(): void {
       this.id = this.route.snapshot.params['id'];
      
  
      this.vegetableService.getVegetableById(this.id,).subscribe(data => {
        this.vegetable = data;
      }, error => console.log(error));
    }

    onSubmit(){
      this.vegetableService.updateVegetable(this.id, this.vegetableService).subscribe( data =>{
         this.goToVegetableList();
        // this.router.navigate(['/vegetables']);
      }
      , error => console.log(error));
    }
  
    goToVegetableList(){
      this.router.navigate(['/update']);
    }
}
