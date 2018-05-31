import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { OrderdetailComponent } from './orderdetail/orderdetail.component';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { DataTableModule } from 'primeng/datatable';
import { DropdownModule } from 'primeng/dropdown';
import { OrderaddComponent } from './orderadd/orderadd.component';


@NgModule({
  declarations: [
    AppComponent,
    OrderlistComponent,
    OrderdetailComponent,
    OrderaddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DataTableModule,
    HttpClientModule,
    InputTextModule,
    FormsModule,
    ButtonModule,
    DropdownModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
