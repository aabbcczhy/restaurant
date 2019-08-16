package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.Menu;

@Service
public interface MenuService {

	int addfood(Menu menu);

	List<Menu> getFoodList();

	int deleteByPrimaryKey(int foodID);

	Menu selectByPrimaryKey(Integer foodID);

	int updateByPrimaryKeySelective(Menu record);

	int updateStatusByPrimaryKey(Menu record);
	
}
