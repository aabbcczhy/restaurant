package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Authority;

@Mapper
@Repository
public interface AuthorityMapper {
	
    int deleteByPrimaryKey(Integer authorityid);

	int insert(Authority record);

	int insertSelective(Authority record);

	Authority selectByPrimaryKey(Integer authorityid);

	int updateByPrimaryKeySelective(Authority record);

	int updateByPrimaryKey(Authority record);
	
	List<Authority> queryAuthorities();
	
	List<String> getByRole(String role);
}