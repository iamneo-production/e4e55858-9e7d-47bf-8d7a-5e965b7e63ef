import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { SearchService } from 'src/app/search.service';
import { CourseService } from 'src/app/services/course.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admincourse',
  templateUrl: './admincourse.component.html',
  styleUrls: ['./admincourse.component.css']
})
export class AdmincourseComponent implements OnInit {
  

  constructor(private courseservice:CourseService,private searchservice:SearchService) { }
  courses;
  searchtext:any;
  sub:Subscription;
 ngOnInit(): void {
  this.sub=this.searchservice.cm.subscribe(data=>this.searchtext=data);
   this.getCourses();
   
 }

 getCourses(){
   this.courseservice.getCourses().subscribe((data:any)=>{
      this.courses=data;
      console.log(data);
   })
 }

 deleteCourse(courseId){
   this.courseservice.deleteCourse(courseId)
   .subscribe((res:any)=> {
     
     Swal.fire('Successfully Deleted !!', res.message, 'success');
     this.ngOnInit();
     
},
(error) => {
  
  console.log("mes");
  console.log(error.message)
  //alert('Something Wrong');
  Swal.fire('Deletion Unsuccess', error.error.message, 'error');
 
})
}

}
