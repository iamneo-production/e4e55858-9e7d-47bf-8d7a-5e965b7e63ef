import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { InstituteData } from '../institute-data';
import { InstitutesService } from '../institutes.service';

@Component({
  selector: 'app-edit-academy',
  templateUrl: './edit-academy.component.html',
  styleUrls: ['./edit-academy.component.css']
})
export class EditAcademyComponent implements OnInit {

  constructor(private router:Router,private route:ActivatedRoute,private service:InstitutesService) { }


  public id:any;
  
  
  ngOnInit(): void {
    // this.route.paramMap.subscribe((params:ParamMap)=>{
    //   this.id=params.get('id')
    //   console.log(this.id)
    // })
  }
  
  institute = new InstituteData("","","","","","","")
  
  onSubmit(){
      this.service.editInstitute(parseInt(this.institute.instituteId),this.institute)
  }


}
