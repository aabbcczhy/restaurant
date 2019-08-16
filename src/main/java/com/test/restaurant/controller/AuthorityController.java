package com.test.restaurant.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.Authority;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.AuthorityService;

@Controller
@RequiresPermissions("管理员管理")
public class AuthorityController {
	
	@Autowired
	AuthorityService authorityservice;
	
	@RequestMapping("/admin-rule")
	public String getAuthorityList(Model model){
		List<Authority> authorityList = authorityservice.getAllAuthorities();
		model.addAttribute("authoritylist", authorityList);
		model.addAttribute("authoritylistsize", (authorityList==null)?0:authorityList.size());
		return "admin-rule";
	}
	
	@PostMapping("/addrule")
	@ResponseBody
	public CommonReturnType addAuthority(Authority authority) throws BusinessException {
		if(authorityservice.addAuthority(authority)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
}
