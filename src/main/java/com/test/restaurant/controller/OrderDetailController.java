package com.test.restaurant.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.restaurant.bean.Menu;
import com.test.restaurant.bean.OrderDetail;
import com.test.restaurant.bean.OrderMaster;
import com.test.restaurant.service.MenuService;
import com.test.restaurant.service.OrderDetailService;
import com.test.restaurant.service.OrderMasterService;

@Controller
@RequiresPermissions("订单管理")
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	OrderMasterService orderMasterService;
	
	@RequestMapping("/order-detail")
	public String showOrderDetail(Integer orderno,Model model) {
		int i=0;
		//根据orderno获取orderDetail
		List<OrderDetail> orderDetailList = orderDetailService.selectByOrderno(orderno);
		List<Menu> menuList = new ArrayList<Menu>();
		//获取订单总额
		OrderMaster orderMaster = new OrderMaster();
		orderMaster = orderMasterService.selectByPrimaryKey(orderno);
		BigDecimal orderSum = orderMaster.getOrdersum();
		//根据orderDetail中的foodID获取menu对象并且放到List中
		for(i=0;i<orderDetailList.size();i++) {
			
			Menu menu = new Menu();
			OrderDetail orderDetail = new OrderDetail();
			orderDetail = orderDetailList.get(i);
			int foodID = orderDetail.getFoodid();
			menu = menuService.selectByPrimaryKey(foodID);
			menuList.add(menu);
		}
		//返回数据到前端
		model.addAttribute("orderSum", orderSum);
		model.addAttribute("menuList", menuList);
		model.addAttribute("orderDetailList", orderDetailList);
		return "order-detail";
	}
}
