package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Role;

@Mapper
@Repository
public interface RoleMapper {
	
    int deleteByPrimaryKey(Integer roleid);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer roleid);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
    
    List<Role> queryAllRole();
    
    List<String> getRoleByEmail(String email);

}