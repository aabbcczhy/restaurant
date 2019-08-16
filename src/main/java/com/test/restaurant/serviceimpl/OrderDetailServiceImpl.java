package com.test.restaurant.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.restaurant.bean.OrderDetail;
import com.test.restaurant.dao.OrderDetailMapper;
import com.test.restaurant.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	OrderDetailMapper orderDetailMapper;
	
	public List<OrderDetail> selectByOrderno(Integer orderno) {
		return orderDetailMapper.selectByOrderno(orderno);
	}

}
