package com.test.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurant.bean.Manager;
import com.test.restaurant.bean.Managerpassword;
import com.test.restaurant.error.BusinessException;

@Service
public interface ManagerService {
	
	int updateManager(Manager manager,Managerpassword managerpassword);
	
	int getManagerNum(String username);
	
	int deleteManager(Integer managerid);

	List<Manager> querymanager(String page, String username) throws BusinessException;
	
	Manager getManagerInfo(Integer managerid);
	
	int addManager(Manager manager,Managerpassword password) throws BusinessException;
	
	String getPasswordByEmail(String email);
	
	Manager getManagerInfoByEmail(String email);
}
