package com.test.restaurant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Empower;

@Mapper
@Repository
public interface EmpowerMapper {
	
    int deleteByPrimaryKey(Integer authorizeid);

	int insert(Empower record);

	int insertSelective(Empower record);

	Empower selectByPrimaryKey(Integer authorizeid);
	
	List<Empower> selectByRoleID(Integer roleid);

	int updateByPrimaryKeySelective(Empower record);

	int updateByPrimaryKey(Empower record);

}