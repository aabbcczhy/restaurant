package com.test.restaurant.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.restaurant.response.CommonReturnType;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handlerException(HttpServletRequest request,Exception e) {
		CommonReturnType commonReturnType = new CommonReturnType();
		commonReturnType.setStatus("fail");
		Map<String,Object> responseData = new HashMap<>();
		if(e instanceof BusinessException){
			BusinessException businessException = (BusinessException)e;
			responseData.put("errorCode", businessException.getErrorCode());
			responseData.put("errorMessage", businessException.getErrorMessage());
			commonReturnType.setData(responseData);
		}else {
			responseData.put("errorCode", EmError.UNKNOWN_ERROR.getErrorCode());
			responseData.put("errorMessage", EmError.UNKNOWN_ERROR.getErrorMessage());
			commonReturnType.setData(responseData);
		}
		return commonReturnType;
	}
	
	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.OK)
	public String handlerAuthorizationException(HttpServletRequest response,AuthorizationException e) {
		return "/error/403";
	}
}
