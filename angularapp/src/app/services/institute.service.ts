import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { InstituteData } from './institute-data';
import { Institute } from './institute';
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


  geturl = "http://localhost:8080/viewInstitutes"
  getInstitutes(): Observable<Institute[]> {
    return this.http.get<Institute[]>(this.geturl)
      .pipe(
        catchError(this.errorHandler)
      )
  }


  posturl = "http://localhost:8080/addInstitute"
  postData(institute: Institute): Observable<Institute> {
    return this.http.post<InstituteData>(this.posturl, JSON.stringify(institute), this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  editurl = "http://localhost:8080/editInstitute"
  editInstitute(id: number, data: Institute) {
    console.log(data);
    return this.http.put(this.editurl + "/" + id, JSON.stringify(data), this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }


  deleteurl = "http://localhost:8080/deleteInstitute"
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
}
