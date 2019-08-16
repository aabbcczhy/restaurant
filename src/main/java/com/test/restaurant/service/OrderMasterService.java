package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.OrderMaster;
@Service
public interface OrderMasterService {
	
	List<OrderMaster> getOrderList();
	 
	int deleteByPrimaryKey(Integer orderno);
	 
	OrderMaster selectByPrimaryKey(Integer orderno);
	 
}
