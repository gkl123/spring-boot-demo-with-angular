package org.demo.goods.service;

import org.demo.goods.model.DemoOrder;
import org.demo.goods.serviceimpl.OrderRemoteServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="app-demo", fallback=OrderRemoteServiceFallback.class)
public interface OrderService {
    
    @RequestMapping(value="/order/getOrder", method=RequestMethod.GET)
    public DemoOrder getDemoOrder(@RequestParam(value="id") String id);
}
