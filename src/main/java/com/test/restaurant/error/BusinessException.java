package com.test.restaurant.error;

//包装器业务异常类实现
public class BusinessException extends Exception implements CommonError{
	/**
	 * 
	 */
	private static final long serialVersionUID = -107498258208632656L;
	private CommonError commonError;
	
	//接收EmError传参，用于构造业务逻辑异常
	public BusinessException(CommonError commonError) {
		super();
		this.commonError = commonError;
	}
	
	//接收自定义errMessage的方式构造业务逻辑异常
	public BusinessException(CommonError commonError,String errorMessage) {
		super();
		this.commonError = commonError;
		this.commonError.setErrorMessage(errorMessage);
	}
	
	@Override
	public int getErrorCode() {
		return this.commonError.getErrorCode();
	}

	@Override
	public String getErrorMessage() {
		return this.commonError.getErrorMessage();
	}

	@Override
	public CommonError setErrorMessage(String msg) {
		this.commonError.setErrorMessage(msg);
		return null;
	}

}
