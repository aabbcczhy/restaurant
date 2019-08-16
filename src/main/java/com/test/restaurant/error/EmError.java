package com.test.restaurant.error;

public enum EmError implements CommonError{
	//通用错误类型10000
	PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
	UNKNOWN_ERROR(10002,"未知错误"),
	//20000开头为用户信息相关错误定义
	USER_NOT_EXIST(20001,"用户名不存在"),
	WRONG_USERNAME_OR_PASSWORD(20002,"用户名或密码输入错误"),
	WRONG_OLDPASSWORD_ERROR(20003,"原密码错误"),
	//30000开头为权限不足错误定义
	REQUIRE_PERMISSION_ERROR(30001,"没有权限访问")
	;
	private int errorCode;
	private String errorMessage;
	private EmError (int errorCode,String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	@Override
	public int getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMessage() {
		return this.errorMessage;
	}

	@Override
	public CommonError setErrorMessage(String msg) {
		this.errorMessage = msg;
		return this;
	}

}
