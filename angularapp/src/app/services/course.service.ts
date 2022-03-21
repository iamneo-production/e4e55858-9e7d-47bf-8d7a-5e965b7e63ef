import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http:HttpClient) { }
  public addCourse(course:any){
    return this.http.post(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/addcourse`,course);

  }
  public getCourses(){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getcourses`);
  }
  public getCoursesbyInstituteId(instituteId){
    
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getcourses/instituteid/${instituteId}`);
  }
  public deleteCourse(courseId){
    return this.http.delete(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/deletecourse/${courseId}`);
  }

  public getCourse(courseId){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getcourse/${courseId}`)
  }
  public updateCourse(course){
    return this.http.post(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/updatecourse`,course);
  }
}
