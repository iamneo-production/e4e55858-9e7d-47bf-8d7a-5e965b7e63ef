import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Institute } from '../institute';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class InstituteService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  geturl = "https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/admin/viewInstitutes"
  getInstitutes(): Observable<Institute[]> {
    return this.http.get<Institute[]>(this.geturl)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  public addInstitute(institute:any){
    return this.http.post(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/admin/addInstitute`,institute);

  }

  public getInstitute(instituteId){
    
    return this.http.get(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/getInstitute/${instituteId}`);
  }

  

  
 public editInstitute(id,  Institute) {
  
    return this.http.put(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/admin/editInstitute?instituteId=${id}`,Institute)
      
  }


  deleteurl = "https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/deleteInstitute"
  deleteInstitute(id: Number) {
    return this.http.delete(this.deleteurl + "/" + id, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }



  errorHandler(error: any) {
    console.log('error occurred')
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }

  checkInstituteId(id){
    return this.http.get<any>(`https://8080-abafacbedafaceebdebdfeadaaaceadb.examlyiopb.examly.io/checkid?instituteId=${id}`);
  }


}