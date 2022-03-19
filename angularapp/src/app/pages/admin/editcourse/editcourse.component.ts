import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';

import { ActivatedRoute } from '@angular/router';
import { CourseService } from 'src/app/services/course.service';
@Component({
  selector: 'app-editcourse',
  templateUrl: './editcourse.component.html',
  styleUrls: ['./editcourse.component.css']
})
export class EditcourseComponent implements OnInit {


  constructor( private courseService:CourseService){ }

  ngOnInit(): void {

     }
   
  

}
