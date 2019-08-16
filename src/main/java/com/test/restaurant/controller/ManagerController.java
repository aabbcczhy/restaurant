package com.test.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.Manager;
import com.test.restaurant.bean.Managerpassword;
import com.test.restaurant.bean.Role;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.ManagerService;
import com.test.restaurant.service.RoleService;

@Controller
@RequiresPermissions("管理员管理")
public class ManagerController {
	
	@Autowired
	ManagerService managerservice;
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/admin-list")
	public String getManagerList(@RequestParam(defaultValue="1") String page,@RequestParam(defaultValue="") String username,Model model) throws BusinessException {
		List<Manager> managerlist = managerservice.querymanager(page,username);
		int num = managerservice.getManagerNum(username);
		model.addAttribute("managerlist",managerlist);
		model.addAttribute("page",page);
		model.addAttribute("num",num);
		return "admin-list";
	}
	
	@RequestMapping("/admin-edit")
	public String editManagerUI(@RequestParam int managerid,Model model) {
		Manager manager = managerservice.getManagerInfo(managerid);
		Role role = roleservice.findRoleByID(manager.getRole());
		model.addAttribute("manager", manager);
		model.addAttribute("rolename", role.getRolename());
		return "admin-edit";
	}
	
	@PostMapping("/addmanager")
	@ResponseBody
	public CommonReturnType addmanager(Manager manager,Managerpassword managerpassword) throws BusinessException {
		if(managerservice.addManager(manager,managerpassword)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@PostMapping("/updatemanager")
	@ResponseBody
	public CommonReturnType updateManager(Manager manager,Managerpassword managerpassword) throws BusinessException {
		if(managerservice.updateManager(manager,managerpassword)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@PostMapping("/deletemanager")
	@ResponseBody
	public CommonReturnType deleteManager(@RequestParam int managerid) throws BusinessException {
		if(managerservice.deleteManager(managerid)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@RequestMapping("/manager-show")
	public String getManagerInfo(Model model) {
		String email = (String) session.getAttribute("name");
		Manager manager = managerservice.getManagerInfoByEmail(email);
		model.addAttribute("manager", manager);
		return "manager-show";
	}
}
