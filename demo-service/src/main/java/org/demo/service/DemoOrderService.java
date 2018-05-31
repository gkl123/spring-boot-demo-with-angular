package org.demo.service;

import java.util.List;

import org.demo.base.BaseService;
import org.demo.model.po.DemoOrder;

public interface DemoOrderService extends BaseService<DemoOrder>{
    List<DemoOrder> listOrder(DemoOrder obj);
}
