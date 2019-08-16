package com.test.restaurant.service;

import org.springframework.stereotype.Service;

import com.test.restaurant.error.BusinessException;

@Service
public interface UserpasswordService {
	
	int modifypass(String newpass, int userid) throws BusinessException;
	
	int checkpass(String oldpass,int userid) throws BusinessException;
	
}
