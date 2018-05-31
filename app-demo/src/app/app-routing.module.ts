import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import { OrderdetailComponent } from './orderdetail/orderdetail.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { OrderaddComponent } from './orderadd/orderadd.component';

const routes : Routes = [
  {path : "order/list", component : OrderlistComponent, 
    children : [{path : "detail/:id" , component : OrderdetailComponent}]
  },
  // {path : "order/list/detail/:id", component : OrderdetailComponent},
  {path : "order/add", component : OrderaddComponent}
]


@NgModule({
  imports: [
    RouterModule.forRoot(routes) 
  ],
  exports : [ RouterModule ]
})
export class AppRoutingModule { }
