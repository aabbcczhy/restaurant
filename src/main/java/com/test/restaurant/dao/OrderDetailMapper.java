package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.OrderDetail;

@Mapper
@Repository
public interface OrderDetailMapper {
	
    int deleteByPrimaryKey(Integer detailid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByOrderno(Integer orderno);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
}