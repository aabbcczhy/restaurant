package com.test.restaurant.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.restaurant.bean.OrderMaster;
import com.test.restaurant.dao.OrderMasterMapper;
import com.test.restaurant.service.OrderMasterService;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

	@Autowired
	OrderMasterMapper orderMasterMapper;
	
	@Override
	public List<OrderMaster> getOrderList() {
		return orderMasterMapper.getOrderList();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer orderno) {
		return orderMasterMapper.deleteByPrimaryKey(orderno);
	}
	
	@Override
	public OrderMaster selectByPrimaryKey(Integer orderno){
		return orderMasterMapper.selectByPrimaryKey(orderno);
	}
	
}
