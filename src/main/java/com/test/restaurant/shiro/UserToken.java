package com.test.restaurant.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginType;
	
	public UserToken(final String username,final String password,String loginType) {
		super(username, password);
		this.setLoginType(loginType);
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
