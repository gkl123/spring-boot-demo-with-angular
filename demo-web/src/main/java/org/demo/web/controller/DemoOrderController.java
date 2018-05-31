package org.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.model.po.DemoOrder;
import org.demo.service.DemoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class DemoOrderController {
	
	@Autowired
	private DemoOrderService demoOrderService;
	
	@RequestMapping("/addOrder")
	@ResponseBody
	public DemoOrder addOrder(@RequestBody DemoOrder order) {
		demoOrderService.add(order);
		return order;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void deleteOrder(@RequestBody DemoOrder order) {
		demoOrderService.delete(order.getId());
	}
	
	@RequestMapping("/listOrder")
    @ResponseBody
	public List<DemoOrder> listOrder(@RequestBody DemoOrder order) {
		return demoOrderService.listOrder(order);
	}
	
	@RequestMapping("getOrder")
	@ResponseBody
	public DemoOrder getDemoOrder(@RequestBody DemoOrder order) {
	    return demoOrderService.get(order.getId());
	}
	
	@RequestMapping("updateOrder")
	@ResponseBody
	public void updateOrder(@RequestBody DemoOrder order) {
	    demoOrderService.update(order);
	}
}
