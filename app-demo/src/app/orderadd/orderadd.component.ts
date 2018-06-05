import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';

import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-orderadd',
  templateUrl: './orderadd.component.html',
  styleUrls: ['./orderadd.component.css']
})
export class OrderaddComponent implements OnInit {
  @Input() order: Order =  new Order;

  constructor(
    private orderService : OrderService,
    private location : Location
  ) { }

  ngOnInit() {
  }

  addOrder() : void {
    this.orderService
      .addOrder(this.order)
      .toPromise()
      .then(rs=>{console.log(rs)})
      .catch(rs=>{console.log(rs)})
      this.location.back();
  }

  goBack(): void {
    this.location.back();
  }
}

