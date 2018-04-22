import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { SignupComponent } from './components/signup/signup.component';
import { ManagerCompaniesComponent } from './components/manager-companies/manager-companies.component';
import { ManagerCompanyDetailsComponent } from './components/manager-company-details/manager-company-details.component';


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    ManagerCompaniesComponent,
    ManagerCompanyDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
