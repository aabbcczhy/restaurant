package com.test.restaurant.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.test.restaurant.bean.Authority;
import com.test.restaurant.dao.AuthorityMapper;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityMapper authorityMapper;
	
	@Override
	public List<Authority> getAllAuthorities() {
		return authorityMapper.queryAuthorities();
	}

	@Override
	public int addAuthority(Authority authority) throws BusinessException {
		if(authority.getAuthorityname()==null || StringUtils.equals(authority.getAuthorityname(), "")) {
			throw new BusinessException(EmError.PARAMETER_VALIDATION_ERROR);
		}else {
			return authorityMapper.insertSelective(authority);
		}
	}

	@Override
	public List<String> getPermissionsByRole(String role) {
		return authorityMapper.getByRole(role);
	}

}
