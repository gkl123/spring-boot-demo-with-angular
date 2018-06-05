import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { Order } from '../order';
import { OrderService } from '../order.service';
import { orders } from '../orders';
import { SelectVo } from '../SelectVo'

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent implements OnInit {
  _orders : Order[];
  selectKey : SelectVo = {name : '手机', key :　'phone'};
  inputValue : string = '';
  results : SelectVo[] = [
    {name : '手机', key :　'phone'},
    {name : '地址', key :　'address'},
    {name : '好评编号', key :　'goodid'},
    {name : '订单编号', key :　'id'}
  ];

  constructor(
    private orderService: OrderService,
    private location : Location
  ) { }

  ngOnInit() {
    this.getOrders();
  }

  getOrders() : void {
    this.orderService.getOrders().subscribe(
      orders => this._orders = orders
    )
  }

  getOrdersSelected() : void {
    this._orders = [];
    console.log({[this.selectKey.key] : this.inputValue})
    this.orderService.getOrdersSelected(this.selectKey.key, this.inputValue).subscribe(
      orders => this._orders = orders
    )

    console.log(this._orders)
  }

  deleteOrder(order : Order) : void {
    console.log(order);
    this.orderService.deleteOrder(order)
    .toPromise()
    .then(rs=>{console.log('delete success') ; this.getOrders();})
    .catch(rs => {console.log(rs)});
    
  }

  

  goBack(): void {
    this.location.back();
  }

}
