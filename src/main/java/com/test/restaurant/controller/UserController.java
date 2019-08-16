package com.test.restaurant.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.bean.User;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.UserService;
import com.test.restaurant.service.UserpasswordService;


@Controller
@RequiresPermissions("用户管理")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	UserpasswordService userpasswordservice;
	
	@RequestMapping("/adduser")
	@ResponseBody
	public CommonReturnType adduser(User user,@RequestParam("pass") String password) throws BusinessException {
		if(userservice.addUser(user, password)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@RequestMapping("/member-list")
	public String getalluser(Model model) throws BusinessException {
		List<User> user=userservice.queryUser();
		if(user.size()>=1) {
			model.addAttribute("userlist", user);
			model.addAttribute("usernum", user.size());
			return "member-list";
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@RequestMapping("/member-edit")
	public String getuser(Model model,@RequestParam("userid") int userid) throws BusinessException{
		User user=userservice.getuserbyid(userid);
		if(user!=null) {
			model.addAttribute("user",user);
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
		return "member-edit";
	}
	
	@RequestMapping("/member-password")
	public String getuserto(Model model,@RequestParam("userid") int userid) throws BusinessException{
		User user=userservice.getuserbyid(userid);
		if(user!=null) {
			model.addAttribute("user",user);
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
		return "member-password";
	}
	
	
	@RequestMapping("/edituser")
	@ResponseBody
	public CommonReturnType memberedit(User user) throws BusinessException {
		if(userservice.updateuser(user)==1) {
			return CommonReturnType.create("null");				
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@RequestMapping("/deluser")
	@ResponseBody
	public CommonReturnType deluser(User user) throws BusinessException {
		if(userservice.deleteByPrimaryKey(user)==1) {
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}
	
	@RequestMapping("/selectuser")
	public String selectuser(Model model,@RequestParam("username") String username) {
		List<User> userlist=userservice.getuserquery(username);
		model.addAttribute("userlist",userlist);
		model.addAttribute("usernum", userlist.size());
		return "member-list";
	}
}
