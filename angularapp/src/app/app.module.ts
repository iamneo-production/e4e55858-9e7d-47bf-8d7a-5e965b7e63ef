import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

//import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
//import { NavbarComponent } from './components/navbar/navbar.component';

//import { LoginComponent} from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule  } from '@angular/material/icon';
import{MatMenuModule} from '@angular/material/menu';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HttpClientModule } from '@angular/common/http';
//import { LoginService } from './login.service';
import { FormsModule } from '@angular/forms';
//import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
// import { authInterceptorProviders } from './auth.interceptor';
// import { SignupComponent } from './pages/signup/signup.component';
//import { ViewacademyComponent } from './pages/user/viewacademy/viewacademy.component';
// import { EnrolledcourseComponent } from './pages/user/enrolledcourse/enrolledcourse.component';
// import { ProfileComponent } from './pages/user/profile/profile.component';
// import { AdminacademyComponent } from './pages/admin/adminacademy/adminacademy.component';
// import { AdmincourseComponent } from './pages/admin/admincourse/admincourse.component';
// import { AdminstudentComponent } from './pages/admin/adminstudent/adminstudent.component';
// import { AdminapprovedapplicationsComponent } from './pages/admin/adminapprovedapplications/adminapprovedapplications.component';
//import { AdminrejectedapplicationsComponent } from './pages/admin/adminrejectedapplications/adminrejectedapplications.component';
//import { SearchComponent } from './components/search/search.component';
//import { UsermanagementComponent } from './pages/admin/usermanagement/usermanagement.component';
// import { UserdataComponent } from './pages/admin/userdata/userdata.component';
// import { ChangepasswordComponent } from './pages/admin/changepassword/changepassword.component';
//import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
  //  NavbarComponent,

    //LoginComponent,
    HomeComponent,
    //AdminDashboardComponent,
    //SignupComponent,
    //ViewacademyComponent,
    //EnrolledcourseComponent,
    // ProfileComponent,
    // EnrolledcourseComponent,
    // AdminacademyComponent,
    // AdmincourseComponent,
    // AdminstudentComponent,
    // AdminapprovedapplicationsComponent,
    // AdminrejectedapplicationsComponent,
    //SearchComponent,
    // UsermanagementComponent,
    // UserdataComponent,
    // ChangepasswordComponent,
    //SignupComponent
  ],
  imports: [
    BrowserModule,
    //AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatSnackBarModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    NgxPaginationModule
    //ReactiveFormsModule,
  ],
  //providers: [authInterceptorProviders],
  providers:[],
  bootstrap: [AppComponent]
})
export class AppModule { }
