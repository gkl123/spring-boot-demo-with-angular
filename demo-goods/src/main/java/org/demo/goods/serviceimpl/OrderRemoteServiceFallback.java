package org.demo.goods.serviceimpl;

import org.demo.goods.model.DemoOrder;
import org.demo.goods.service.OrderService;

public class OrderRemoteServiceFallback implements OrderService {

    public DemoOrder getDemoOrder(String id) {
        return null;
    }

}
