package com.test.restaurant.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.test.restaurant.bean.Userpassword;

@Mapper
@Repository
public interface UserpasswordMapper {
	
    int deleteByPrimaryKey(Userpassword userpassword);
    
    int deleteByUserID(Integer userid);

    int insert(Userpassword record);

    int insertSelective(Userpassword record);

    Userpassword selectByPrimaryKey(Integer id);
    
    Userpassword selectByUserID(Integer userID);

    int updateByPrimaryKeySelective(Userpassword record);

    int updateByPrimaryKey(Userpassword record);
    
}