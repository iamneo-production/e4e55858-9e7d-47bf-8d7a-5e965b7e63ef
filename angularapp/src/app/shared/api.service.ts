import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {map} from 'rxjs/operators'
import { pipe } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl="http://localhost:8080/api/v1/feedback";
  constructor(private http:HttpClient) { }
  postReview(data:any)
  {
    return this.http.post<any>(`${this.baseUrl}`,data)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
  getReview()
  {
    return this.http.get<any>(`${this.baseUrl}`)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
  updateReview(data: any,id:number)
  {
    return this.http.put<any>(`${this.baseUrl}/${id}`,data)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
  deleteReview(id:number)
  {
    return this.http.delete<any>(`${this.baseUrl}/${id}`,)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
}
