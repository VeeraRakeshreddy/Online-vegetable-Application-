import { Component, OnInit } from '@angular/core';
import { VegetablesService } from '../vegetables.service';
import { Vegetable } from '../vegetable';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
import { VegetableInfo } from '../vegetableinfo/vegetableinfo.component';

@Component({
  selector: 'app-showdetails',
  templateUrl: './showdetails.component.html',
  styleUrls: ['./showdetails.component.css']
})
export class ShowdetailsComponent implements OnInit {
  id:any
  vegetable:any
  constructor(private route: ActivatedRoute, private vegetableService: VegetablesService ,) {
  
   }


  ngOnInit(): void {
     this.id = this.route.snapshot.params['id'];
    // this.id=this.vegStore.actualVegetable
    console.log(this.id)
    this.vegetableService.getVegetableById(this.id).subscribe(data =>{
      this.vegetable=data;
    });
  }



}
