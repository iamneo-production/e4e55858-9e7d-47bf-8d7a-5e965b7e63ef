import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminGuard } from './admin.guard';
import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SingupComponent } from './pages/signup/signup.component';
import { ProfileComponent } from './pages/user/profile/profile.component';
import { ViewacademyComponent } from './pages/user/viewacademy/viewacademy.component';
import { EnrolledcourseComponent } from './pages/user/enrolledcourse/enrolledcourse.component';
import { UserGuard } from './user.guard';
import { AdminacademyComponent } from './pages/admin/adminacademy/adminacademy.component';
import { AdmincourseComponent } from './pages/admin/admincourse/admincourse.component';
import { AdminstudentComponent } from './pages/admin/adminstudent/adminstudent.component';
import { AdminapprovedapplicationsComponent } from './pages/admin/adminapprovedapplications/adminapprovedapplications.component';
import { AdminrejectedapplicationsComponent } from './pages/admin/adminrejectedapplications/adminrejectedapplications.component';
import { UsermanagementComponent } from './pages/admin/usermanagement/usermanagement.component';
import { UserdataComponent } from './pages/admin/userdata/userdata.component';
import { ChangepasswordComponent } from './pages/admin/changepassword/changepassword.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
  {
    path: 'signup',
    component: SingupComponent,
    pathMatch: 'full',
  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full',
  },
  
  {path:'admin',canActivate:[AdminGuard],
  children:[
  {path:'',redirectTo:'institutes',pathMatch:'full'},
  {path:'institutes',component:AdminacademyComponent},
  {path:'courses',component:AdmincourseComponent},
  {path:'students',component:AdminstudentComponent},
  {path:'users',component:UsermanagementComponent},
  {path:'users/:userId',component:UserdataComponent},
  {path:'users/:userId/changepassword',component:ChangepasswordComponent},
  {path:'approved',component:AdminapprovedapplicationsComponent},
  {path:'rejected',component:AdminrejectedapplicationsComponent},
  ]},
  
  {path:'user',canActivate:[UserGuard],
  children:[
  {path:'',redirectTo:'viewinstitute',pathMatch:'full'},
  {path:'viewinstitute',component:ViewacademyComponent},
   {path:'enrolledcourse',component:EnrolledcourseComponent},
   {path:'profile',component:ProfileComponent},

]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
