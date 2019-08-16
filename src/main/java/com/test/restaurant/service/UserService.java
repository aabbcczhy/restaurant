package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.User;
import com.test.restaurant.error.BusinessException;

@Service
public interface UserService {
	
	int addUser(User user,String password) throws BusinessException;
	
	List<User> queryUser();
	
	int deleteByPrimaryKey(User user) throws BusinessException;
	
	User getuserbyid(int userid);
	
	int updateuser(User user) throws BusinessException;

	List<User> getuserquery(String username);
	
	String getPasswordByEmail(String email);
	
}
