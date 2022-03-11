import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor( private http:HttpClient) { }

  public addUser(user:any){
    return this.http.post(`http://localhost:8080/user/signup`,user);

  }

  public checkMail(email:string){
    console.log("calling service")
    return this.http.get<any>(`http://localhost:8080/check-email?mail=${email}`);
  }
  
public checkUsername(username:string){
  return this.http.get<any>(`http://localhost:8080/check-username?username=${username}`)
}

public checkMobileNumber(mobileno:string){
  return this.http.get<any>(`http://localhost:8080/check-mobileno?mobileno=${mobileno}`)
}

public adminRoleName(){
  return this.http.get<any>(`http://localhost:8080/AdminRoleName`);
}
public userroleName(){
  return this.http.get<any>(`http://localhost:8080/UserRoleName`);
}


getUsers():Observable<any[]>{
    
  return this.http.get<any[]>(`http://localhost:8080/user/all`)
}
deleteUser(userId){
  console.log(userId)
  return this.http.delete(`http://localhost:8080/user/delete/${userId}`)
}

getUserById(userId){
  console.log(userId);
  return this.http.get(`http://localhost:8080/user/get/${userId}`);
}

updateUser(userId,user){
  
  return this.http.put(`http://localhost:8080/user/edit/${userId}`,user)
}

updatePassword(userId,user){
  
  return this.http.put(`http://localhost:8080/user/changepassword/${userId}`,user)
}

}