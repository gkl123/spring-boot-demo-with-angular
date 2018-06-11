package org.demo.goods.controller;

import org.demo.goods.model.DemoOrder;
import org.demo.goods.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("getOrder")
    public DemoOrder testFeign() {
        DemoOrder order = new DemoOrder();
        order.setId("12312313212");
        return orderService.getDemoOrder("12312313212");
    }
}
