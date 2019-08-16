package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Menu;

@Mapper
@Repository
public interface MenuMapper {
   
	int deleteByPrimaryKey(Integer foodid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer foodid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> getFoodList();
    
}