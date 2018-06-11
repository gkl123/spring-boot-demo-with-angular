package org.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.demo.model.po.DemoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(DemoOrder record);

    int insertSelective(DemoOrder record);

    DemoOrder selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(DemoOrder record);

    int updateByPrimaryKey(DemoOrder record);
    
    List<DemoOrder> selectByProperties(DemoOrder record);
}