package com.test.restaurant.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.response.CommonReturnType;
import com.test.restaurant.service.UserpasswordService;

@Controller
@RequiresPermissions("用户管理")
public class UserpasswordController {
	
	@Autowired
	UserpasswordService userpasswordservice;
	
	@RequestMapping("/modifypass")
	@ResponseBody
	public CommonReturnType modifypass(@RequestParam("oldpass") String oldpass,@RequestParam("repass") String newpass,@RequestParam("userid") int userid) throws BusinessException {
		if(userpasswordservice.checkpass(oldpass, userid)==1) {
			userpasswordservice.modifypass(newpass, userid);
			return CommonReturnType.create("null");
		}else {
			throw new BusinessException(EmError.WRONG_OLDPASSWORD_ERROR);
		}
	}
}