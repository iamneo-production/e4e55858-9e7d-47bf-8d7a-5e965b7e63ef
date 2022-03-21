import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdmissionService } from 'src/app/services/admission.service';

@Component({
  selector: 'app-adminstudent',
  templateUrl: './adminstudent.component.html',
  styleUrls: ['./adminstudent.component.css']
})
export class AdminstudentComponent implements OnInit {
  constructor(private admissionservice:AdmissionService,private router:Router) { }

  admissions;
  ngOnInit(): void {
    this.getAllAdmissions();
  }
  getAllAdmissions(){
    this.admissionservice.getallPendingAdmissions().subscribe((data:any)=>{
       this.admissions=data;
    })
  }

  

}
