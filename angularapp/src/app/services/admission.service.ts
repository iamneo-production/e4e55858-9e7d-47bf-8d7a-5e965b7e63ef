import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdmissionService {
  constructor(private http:HttpClient) { }

  public saveAdmission(userid,admission){
    return this.http.post(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/saveAdmission/${userid}`,admission);
  }
   
  public getallPendingAdmissions(){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/pending`);
  }
  public getallRejectedAdmissions(){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/rejected`);
  }
  public getallApprovedAdmissions(){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/approved`);
  }

  public getAdmission(admissionId){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getadmission/${admissionId}`);
  }

  public approveApplication(admissionId){
    return this.http.put(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/approve/${admissionId}`,'');
  }

  public rejectApplication(admissionId){
    return this.http.put(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/reject/${admissionId}`,'');
  
  }
  public getCourses(instituteId){
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getcourses/instituteid/${instituteId}`);
  }

  public editAdmission(admission){
    return this.http.put(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/editadmission`,admission);
  }
}
