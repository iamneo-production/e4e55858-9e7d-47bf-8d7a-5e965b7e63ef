import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-editcourse',
  templateUrl: './editcourse.component.html',
  styleUrls: ['./editcourse.component.css']
})
export class EditcourseComponent implements OnInit {

  editCourseForm!:  FormGroup;
  constructor(private formBuilder: FormBuilder, private api:ApiService, private router:ActivatedRoute){ }

  ngOnInit(): void {
   
    
    this.editCourseForm = this.formBuilder.group({
      courseName :['',Validators.required],
      courseDuration :['',Validators.required],
      courseStartTimming :['',Validators.required],
      courseEndTimming :['',Validators.required],
      courseEnrolled :['',Validators.required],
      courseDescription :['',Validators.required],

    })

     this.api.getCurrentCourse(this.router.snapshot.params['id']).subscribe((result)=>{
      console.log(result);
      this.editCourseForm = this.formBuilder.group({
        courseName :result['courseName'],
        courseDuration :result['courseDuration'],
        courseStartTimming :result['courseStartTimming'],
        courseEndTimming :result['courseEndTimming'],
        courseEnrolled :result['courseEnrolled'],
        courseDescription :result['courseDescription'],
  
      })
    })
   
  }
  updateCourse(){
    this.api.updateCourse(this.router.snapshot.params['id'],this.editCourseForm.value).
     
    //  
    subscribe({
      next:(result)=>{
        alert("Course Updated Succesfully")
        this.editCourseForm.reset();
        //this.ngOnInit();
        
      },
      error:()=>{
        alert("Error While Updating the Course")
      }
    })
    
    
  }  
}
