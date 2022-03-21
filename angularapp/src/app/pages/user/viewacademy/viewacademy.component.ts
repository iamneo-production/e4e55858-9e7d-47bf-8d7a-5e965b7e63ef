import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InstituteService } from 'src/app/services/institute.service';

@Component({
  selector: 'app-viewacademy',
  templateUrl: './viewacademy.component.html',
  styleUrls: ['./viewacademy.component.css']
})
export class ViewacademyComponent implements OnInit {


  constructor(private instituteService:InstituteService,private router:Router) { }
   institutes;
  ngOnInit(): void {
    this.instituteService.getInstitutes().subscribe((data)=>this.institutes=data);
   
    
  }

 
}
