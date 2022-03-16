import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Institute } from '../institute';
import { InstituteData } from '../institute-data';
import { InstitutesService } from '../institutes.service';

@Component({
  selector: 'app-view-academy',
  templateUrl: './view-academy.component.html',
  styleUrls: ['./view-academy.component.css']
})
export class ViewAcademyComponent implements OnInit {

  institutes:Institute[]=[]

  constructor(private instituteService:InstitutesService,private router:Router) { }

  ngOnInit(): void {
    this.instituteService.getInstitutes().subscribe((data)=>this.institutes=data)
  }

  editAcademy(id:string){
      this.router.navigate(['/editAcademy',id])
  }

  // editInstitute(i:Number,institute:InstituteData){
  //     this.instituteService.editInstitute(i,institute)
  // }

  deleteInstitute(id:string){
      this.instituteService.deleteInstitute(parseInt(id))
      .subscribe(res => {
        console.log('Post deleted successfully!');
   })
  }

}

