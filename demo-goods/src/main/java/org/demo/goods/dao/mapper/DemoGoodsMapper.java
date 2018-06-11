package org.demo.goods.dao.mapper;

import org.demo.goods.model.DemoGoods;

public interface DemoGoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DemoGoods record);

    int insertSelective(DemoGoods record);

    DemoGoods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DemoGoods record);

    int updateByPrimaryKey(DemoGoods record);
}