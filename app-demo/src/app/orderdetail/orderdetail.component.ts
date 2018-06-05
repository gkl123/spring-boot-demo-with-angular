import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Alert } from 'selenium-webdriver';

@Component({
  selector: 'app-orderdetail',
  templateUrl: './orderdetail.component.html',
  styleUrls: ['./orderdetail.component.css']
})
export class OrderdetailComponent implements OnInit {

  @Input() order: Order = new Order;

  constructor(
    private orderService: OrderService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.getOrderDetail();
  }

  getOrderDetail(): Order {
    const id: string = this.route.snapshot.paramMap.get('id');
    console.log("详情打印出来的" + id);
    this.orderService.getOrderById(id).subscribe(
      _order => this.order = _order
    )
    return null;
  }

  goBack(): void {
    this.location.back();
  }

  updateOrder(): void {
    this.orderService.updateOrder(this.order)
    .toPromise()
    .then();
    this.location.back();
  }

}
