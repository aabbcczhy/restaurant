package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.OrderMaster;

@Mapper
@Repository
public interface OrderMasterMapper {
    
	int deleteByPrimaryKey(Integer orderno);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(Integer orderno);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
    
    List<OrderMaster> getOrderList();
    
}