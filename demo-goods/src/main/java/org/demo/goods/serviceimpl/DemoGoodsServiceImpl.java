package org.demo.goods.serviceimpl;

import org.demo.base.BaseServiceImpl;
import org.demo.goods.dao.mapper.DemoGoodsMapper;
import org.demo.goods.model.DemoGoods;
import org.demo.goods.service.DemoGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoGoodsServiceImpl extends BaseServiceImpl<DemoGoods> implements DemoGoodsService {
    
    @Autowired
    private DemoGoodsMapper goodsMapper;

    public void add(DemoGoods obj) {
        goodsMapper.insert(obj);
    }

    public void update(DemoGoods obj) {
        goodsMapper.updateByPrimaryKey(obj);
    }

    public void delete(String id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    public DemoGoods get(String id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

}
