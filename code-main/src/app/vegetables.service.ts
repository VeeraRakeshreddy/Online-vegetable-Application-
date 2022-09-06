import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vegetable } from './vegetable';



@Injectable({
  providedIn: 'root'
})
export class VegetablesService {

  selectedVegetable:any;
  rootEndpoint:string='http://localhost:8080/vegetable/'
  AllVegetablesEndPoint:string = this.rootEndpoint+'allvegetable';
  FilterEndpoint:string='http://localhost:8080/vegetable/vegetablefromHtoL';
  FilterEndpoint2:string='http://localhost:8080/vegetable/vegetablefromLtoH';
  FilterRating:String='http://localhost:8080/vegetable/vegetablebyRating'
  logout:String='http://localhost:8080/vegetables/user/logout';
  update:String='http://localhost:8080/vegetable/vegetables';
  private http:HttpClient;

  
  vegetables:any[]=[];
  
 

  constructor( http1:HttpClient) {
    this.http=http1
   
    
   }
      
  getAllvegetables():Observable<any>{
    return this.http.get<any>(`${this.AllVegetablesEndPoint}`);

  }
  
  getAll():Observable<Vegetable>
  {
    return this.http.get<Vegetable>(`${this.AllVegetablesEndPoint}`);
  }

  receivevegetables(obj:any){
    this.selectedVegetable=obj;
  }
  cartvegetable(obj:any){
    this.vegetables.push(obj);

  }
  getfilter():Observable<any>{
    return this.http.get<any>(`${this.FilterEndpoint}`);

  }
  getfilter1():Observable<any>{
    return this.http.get<any>(`${this.FilterEndpoint2}`);
  }
  getRating():Observable<any>{
    return this.http.get<any>(`${this.FilterRating}`);
  }
  logoutpart():Observable<any>
  {
return this.http.get<any>(`${this.logout}`);
  }
  updateVegetable(id: number, vegetable: any): Observable<Object>{
    return this.http.put(`${this.update}/${id}`, vegetable);
  }
  
  deleteVegetable(id: number): Observable<Object>{
    return this.http.delete(`${this.update}/${id}`);
  }
  //getVegetableById(id:any): Observable<Vegetable>{
    // return this.http.get<Vegetable>(`${this.update +'/'+id.toString()}`);

    // const options = {
    //   params: new HttpParams().set('id', id)
    // };
    // return this.http.get<Vegetable>(`http://localhost:8080/vegetable/vegetables/${id}`, options);
    // }

    getVegetableById(id:number):Observable<Vegetable>{
      return this.http.get<Vegetable>(`${this.update}/${id}`);
    }
   
  
 
 
}