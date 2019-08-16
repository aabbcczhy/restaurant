package com.test.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.OrderMaster;
import com.test.restaurant.bean.User;
import com.test.restaurant.service.OrderMasterService;
import com.test.restaurant.service.UserService;

@Controller
@RequiresPermissions("订单管理")
public class OrderMasterController {
	
	@Autowired
	OrderMasterService orderMasterService;
	
	@Autowired
	UserService userService;
	
	//显示订单
	@RequestMapping("/order-list")
	public String getAllOrder(Model model) {
		int i=0;
		List<OrderMaster> orderList = orderMasterService.getOrderList();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		OrderMaster  orderMaster= new OrderMaster();
		int orderQun = orderList.size();
		for(i=0;i<orderList.size();i++) {
			orderMaster = orderList.get(i);
			Integer userid = orderMaster.getUserid();
			user=userService.getuserbyid(userid);
			userList.add(user);
		}
		model.addAttribute("orderQun", orderQun);
		model.addAttribute("orderList", orderList);
		model.addAttribute("userList", userList);
		return "order-list";
	}
	//删除订单
	@RequestMapping("/deleteByPrimaryKey")
	@ResponseBody
	public String deleteByPrimaryKey(Integer orderno){
		orderMasterService.deleteByPrimaryKey(orderno);
		return "success";
	}
}
