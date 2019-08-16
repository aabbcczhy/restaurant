package com.test.restaurant.error;

public interface CommonError {
	
	int getErrorCode();
	
	String getErrorMessage();
	
	CommonError setErrorMessage(String msg);
	
}
