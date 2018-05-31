package org.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.demo.base.BaseServiceImpl;
import org.demo.dao.mapper.DemoOrderMapper;
import org.demo.model.po.DemoOrder;
import org.demo.service.DemoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoOrderServiceImpl extends BaseServiceImpl<DemoOrder> implements DemoOrderService {
	
	@Autowired
	private DemoOrderMapper demoOrderMapper;
	
	Logger logger = Logger.getLogger(DemoOrderServiceImpl.class);
	
	public void add(DemoOrder obj) {
		logger.info(demoOrderMapper);
		String id = getId();
		obj.setId(id);
		obj.setCreatetime(new Date());
		demoOrderMapper.insert(obj);
		
	}

	public void update(DemoOrder obj) {
		demoOrderMapper.updateByPrimaryKey(obj);
		
	}

	public void delete(String id) {
		demoOrderMapper.deleteByPrimaryKey(id);
		
	}

	public DemoOrder get(String id) {
		return demoOrderMapper.selectByPrimaryKey(id);
	}
	
	public List<DemoOrder> listOrder(DemoOrder obj) {
		return demoOrderMapper.selectByProperties(obj);
	}
}
