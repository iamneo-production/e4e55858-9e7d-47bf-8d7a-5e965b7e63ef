import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  courseForm!: FormGroup;
  open: any;
  constructor(private formBuilder: FormBuilder, private api:ApiService) { }

  ngOnInit(): void {
    this.courseForm = this.formBuilder.group({
      courseName :['',Validators.required],
      courseDuration :['',Validators.required],
      courseStartTimming :['',Validators.required],
      courseEndTimming :['',Validators.required],
      courseEnrolled :['',Validators.required],
      courseDescription :['',Validators.required],

    })

  }
  addCourse(){
    if(this.courseForm.valid){
      this.api.postCourse(this.courseForm.value)
      .subscribe({
        next:(res)=>{
          alert("Courses Added Succesfully")
          this.courseForm.reset();
         // this.ngOnInit();
          
        },
        error:()=>{
          alert("Error While adding the Course")
        }
      })

    }
  }

}
