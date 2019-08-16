package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.Role;
import com.test.restaurant.error.BusinessException;

@Service
public interface RoleService {
	
	List<Role> getRoleList();
	
	List<String> getRolesByEmail(String email);
	
	int addRole(Role role,Integer[] authorityid) throws BusinessException;
	
	Role findRoleByID(Integer roleid);
	
}
