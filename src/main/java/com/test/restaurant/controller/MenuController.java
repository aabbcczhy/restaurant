package com.test.restaurant.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.Menu;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.MenuService;

@Controller
@RequiresPermissions("菜单管理")
public class MenuController {

	@Autowired
	MenuService menuservice;
	
	//显示所有菜品
	@RequestMapping("/food-list")
	public String food_list(Model model){
		List<Menu> menuList = new ArrayList<Menu>();
		menuList = menuservice.getFoodList();
		int size = menuList.size();
		model.addAttribute("menusize",size);
		model.addAttribute("menuList",menuList);
		return "food-list";
	}
	
	//编辑菜品页面
	@RequestMapping("/food-edit")
	public String food_edit(Integer foodid,Model model) {
		Menu menu = new Menu();
		menu = menuservice.selectByPrimaryKey(foodid);
		model.addAttribute("foodid", foodid);
		model.addAttribute("menu", menu);
		return "food-edit";
	}
	
	//添加菜品页面
	@RequestMapping("/food-add.html")
	public String food_add() {
		return "food-add";
	}
	
	//添加菜品
	@RequestMapping("/food_add")
	@ResponseBody
	public CommonReturnType food_add(Menu menu) throws BusinessException {
		if(menuservice.addfood(menu)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	//删除菜品&批量删除
	@RequestMapping("/deleteByfoodID")
	@ResponseBody
	public CommonReturnType deleteByPrimaryKey(Integer foodID) throws BusinessException {
		if(menuservice.deleteByPrimaryKey(foodID)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	//修改菜品信息
	@RequestMapping("/updateByPrimaryKeySelective")
	@ResponseBody
	public String updateByPrimaryKeySelective(Integer foodid,String foodname,BigDecimal price) throws BusinessException {
		Menu menu = new Menu();
		menu.setFoodid(foodid);
		menu.setFoodname(foodname);
		menu.setPrice(price);
		menuservice.updateByPrimaryKeySelective(menu);
		return "success";
	}
	//修改菜品状态
	@RequestMapping("/updateStatusByPrimaryKey")
	@ResponseBody
	public String updateStatusByPrimaryKey(Integer foodid,Byte status) {
		Menu menu  = new Menu();
		menu.setFoodid(foodid);
		menu.setStatus(status);
		menuservice.updateStatusByPrimaryKey(menu);
		return "success";
	}
}
