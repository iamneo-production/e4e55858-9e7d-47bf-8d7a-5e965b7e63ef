import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
public url="https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io"

  constructor(private http:HttpClient) { }
  public addReview(userId,review){
    return this.http.post(`${this.url}/addReview/${userId}`,review);

  }

  public getAvgReview(instituteId){
    return this.http.get(`${this.url}/averageRate?instituteId=${instituteId}`);
  }

  public getallReviews(instituteId){
    return this.http.get(`${this.url}/allReviews/${instituteId}`);

  }
}
