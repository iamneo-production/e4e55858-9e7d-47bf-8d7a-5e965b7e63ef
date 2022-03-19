import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admincourse',
  templateUrl: './admincourse.component.html',
  styleUrls: ['./admincourse.component.css']
})
export class AdmincourseComponent implements OnInit {
  displayedColumns: string[] = ['courseName', 'courseDuration', 'courseStartTimming', 'courseEndTimming','courseEnrolled','courseDescription','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


   constructor(private api:ApiService,   ) { 

    }

  ngOnInit(): void {
    this.getAllCourse();
    
  }

  
  getAllCourse(){
    this.api.getCourse()
    .subscribe({
      next:(res)=>{
        this.dataSource=new MatTableDataSource(res);
        this.dataSource.paginator=this.paginator;
        this.dataSource.sort=this.sort
      },
      error:(err)=>{
        alert("Error while fatching the courses")
      }
    })
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  
  deleteCourse(id:number){
    this.api.deleteCourse(id)
    .subscribe({
      next:(res)=>{
        alert("Product Deleted Succesfully!!")
        this.getAllCourse();
      },
      error:()=>{
        alert("Error while deleting the product!!")
      }
    })
  }

}

  


