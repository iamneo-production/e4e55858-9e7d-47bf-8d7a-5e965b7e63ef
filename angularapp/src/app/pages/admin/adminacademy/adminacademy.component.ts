import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminacademy',
  templateUrl: './adminacademy.component.html',
  styleUrls: ['./adminacademy.component.css']
})
export class AdminacademyComponent implements OnInit {

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


