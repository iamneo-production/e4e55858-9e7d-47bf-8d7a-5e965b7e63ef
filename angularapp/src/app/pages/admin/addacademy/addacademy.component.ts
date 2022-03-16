import { InstitutesService } from './../institutes.service';
import { Component, OnInit } from '@angular/core';
import { InstituteData } from '../institute-data';

@Component({
  selector: 'app-add-academy',
  templateUrl: './add-academy.component.html',
  styleUrls: ['./add-academy.component.css']
})
export class AddAcademyComponent implements OnInit {

  constructor(private instituteService: InstitutesService) { }

  ngOnInit(): void {
  }

  institute = new InstituteData("","", "", "", "", "", "");


  onSubmit() {
    this.instituteService.postData(this.institute)
      .subscribe(res => {
        console.log('Post created successfully!');
      })

    this.institute = new InstituteData("","", "", "", "", "", "");
  }

}
