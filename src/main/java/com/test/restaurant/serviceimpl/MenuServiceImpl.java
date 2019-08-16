package com.test.restaurant.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.restaurant.bean.Menu;
import com.test.restaurant.dao.MenuMapper;
import com.test.restaurant.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public int addfood(Menu menu) {
		return menuMapper.insertSelective(menu);
	}
	
	@Override
	public List<Menu> getFoodList(){
		List<Menu> menuList = new ArrayList<Menu>();
		menuList = menuMapper.getFoodList();
		return menuList;
	}
	
	@Override
	public int deleteByPrimaryKey(int foodID) {
		return menuMapper.deleteByPrimaryKey(foodID);
	}
	
	@Override
	public Menu selectByPrimaryKey(Integer foodID){
		return menuMapper.selectByPrimaryKey(foodID);
	}
	
	@Override
	public int updateByPrimaryKeySelective(Menu record){
		return 	menuMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public int updateStatusByPrimaryKey(Menu record) {	//修改菜品状态
		return menuMapper.updateByPrimaryKeySelective(record);
	}

}
