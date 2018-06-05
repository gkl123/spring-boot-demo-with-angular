import { Injectable } from '@angular/core';
import { Order } from './order';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  // httpOptions = {  
  //   headers: new HttpHeaders({ 'Content-Type': 'application/json;application/x-www-form-urlencodeed; charset=utf-8'})  
  // };  

  constructor(
    private http: HttpClient
  ) { }

  getOrderById(oid : string) : Observable<Order> {
    const uri : string = "http://localhost:8091/order/getOrder";
    return this.http.post<Order>(uri, {id : oid});
  }

  getOrders() : Observable<Order[]> {
    const uri : string = 'http://localhost:8091/order/listOrder';
    return this.http.post<Order[]>(uri, {});
  }

  getOrdersSelected(selectKey : string, inputValue : string) : Observable<Order[]> {
    const uri : string = 'http://localhost:8091/order/listOrder';
    return this.http.post<Order[]>(uri, {[selectKey] : inputValue});
  }

  addOrder(order : Order) : Observable<Order> {
    console.log(order)
    const uri : string = 'http://localhost:8091/order/addOrder';
    return this.http.post<Order>(uri, order);
  }

  updateOrder(order : Order) : Observable<Order> {
    const uri : string = 'http://localhost:8091/order/updateOrder';
    return this.http.post<Order>(uri, order);
  }

  deleteOrder(order : Order) : Observable<Order> {
    const uri : string = 'http://localhost:8091/order/delete';
    return this.http.post<Order>(uri, order);
  }
}
