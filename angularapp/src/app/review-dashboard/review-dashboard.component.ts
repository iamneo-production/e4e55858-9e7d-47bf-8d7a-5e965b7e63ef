import { Component, OnInit} from '@angular/core';
import {FormBuilder,FormGroup} from '@angular/forms'
import { ReviewModel } from './review-dash board.model';

import { ApiService } from '../shared/api.service';


@Component({ 
  selector: 'app-review-dashboard', 
  templateUrl: './review-dashboard.component.html', 
  styleUrls: ['./review-dashboard.component.css'] 
}) 
export class ReviewDashboardComponent implements OnInit { 

  formValue !: FormGroup; 
  reviewModelObj:ReviewModel=new ReviewModel(); 
  reviewData !:any; 
  showAdd!:boolean; 
  showUpdate!:boolean; 
  constructor(private formBuilder:FormBuilder, 
    private api:ApiService) { } 

//Here taking name, rating and testarea for review
  ngOnInit(): void { 
    this.formValue=this.formBuilder.group( 
      { 
        name : [''], 
        rating : [''], 
        textarea : [''] 

      } 
    ) 
    this.getAllReviews(); 
  } 
  clickAddReview() 
  { 
    this.formValue.reset(); 
    this.showAdd=true; 
    this.showUpdate=false; 

  } 
  postReviewDetails() 
  { 
    this.reviewModelObj.name=this.formValue.value.name; 
    this.reviewModelObj.rating=this.formValue.value.rating; 
    this.reviewModelObj.textarea=this.formValue.value.textarea; 

    this.api.postReview(this.reviewModelObj) 
    .subscribe(res=>{ 
      console.log(res); 
      alert("Review added successfully") 
      let ref=document.getElementById('cancel') 
      ref?.click(); 
      this.formValue.reset(); 
      this.getAllReviews(); 
    }, 
    err=>{ 
      alert("Something went wrong"); 
    } 
    ) 
  } 

//this method is for showing all review 
  getAllReviews() 
  { 
    this.api.getReview() 
    .subscribe(res=>{ 
      this.reviewData=res; 

    }) 
  }
//this method is for delete purpose
  deleteReview(row:any) 
  { 
    this.api.deleteReview(row.id) 
    .subscribe(res=>{ 
      alert("Review Deleted"); 
      this.getAllReviews(); 
    }) 
  } 
//this method is for edit purpose
  onEdit(row:any) 
  { 
    this.showAdd=false; 
    this.showUpdate=true; 
    this.reviewModelObj.id=row.id; 
    this.formValue.controls['name'].setValue(row.name) 
    this.formValue.controls['rating'].setValue(row.rating) 
    this.formValue.controls['textrarea'].setValue(row.textarea) 
  } 
//this function is for update purpose
  updateReviewDetails() 
  { 
    this.reviewModelObj.name=this.formValue.value.name; 
    this.reviewModelObj.rating=this.formValue.value.rating; 
    this.reviewModelObj.textarea=this.formValue.value.textarea; 
    this.api.updateReview(this.reviewModelObj,this.reviewModelObj.id) 
    .subscribe(res=>{ 
      alert("Updated Successfully"); 
      let ref=document.getElementById('cancel') 
      ref?.click(); 
      this.formValue.reset(); 
      this.getAllReviews(); 
    }) 
  } 

} 
