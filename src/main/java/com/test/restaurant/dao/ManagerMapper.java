package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Manager;

@Mapper
@Repository
public interface ManagerMapper {
	
    int deleteByPrimaryKey(Integer managerid);

	int insert(Manager record);

	int insertSelective(Manager record);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);

    List<Manager> querymanager(Integer page,String username);
    
    int getmanagersize(String username);
    
    Manager selectByPrimaryKey(Integer managerid);
    
    Manager selectByEmail(String email);
    
}