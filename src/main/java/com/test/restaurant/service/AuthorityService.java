package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.Authority;
import com.test.restaurant.error.BusinessException;

@Service
public interface AuthorityService {
	
	List<Authority> getAllAuthorities();
	
	List<String> getPermissionsByRole(String role);
	
	int addAuthority(Authority authority) throws BusinessException;
	
}
