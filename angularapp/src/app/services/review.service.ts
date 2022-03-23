import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http:HttpClient) { }
  public addReview(userId,review){
    return this.http.post(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/addReview/${userId}`,review);

  }

  public getAvgReview(instituteId){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/averageRate?instituteId=${instituteId}`);
  }
}
