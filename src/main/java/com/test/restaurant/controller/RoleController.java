package com.test.restaurant.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.Authority;
import com.test.restaurant.bean.Role;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.AuthorityService;
import com.test.restaurant.service.RoleService;

@Controller
@RequiresPermissions("管理员管理")
public class RoleController {
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	AuthorityService authorityservice;
	
	@RequestMapping("/admin-role")
	public String getRoleList(Model model) {
		List<Role> rolelist = roleservice.getRoleList();
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("rolelistsize", rolelist.size());
		return "admin-role";
	}
	
	@RequestMapping("/role-add")
	public String addRoleUI(Model model) {
		List<Authority> authorityList = authorityservice.getAllAuthorities();
		model.addAttribute("authoritylist", authorityList);
		return "role-add";
	}
	
	@RequestMapping("/addrole")
	@ResponseBody
	public CommonReturnType addRole(Role role,Integer[] authorityid) throws BusinessException  {
		if(roleservice.addRole(role, authorityid)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
}
