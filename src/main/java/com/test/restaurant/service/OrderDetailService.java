package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.OrderDetail;

@Service
public interface OrderDetailService {
	
	List<OrderDetail> selectByOrderno(Integer orderno);
	
}
