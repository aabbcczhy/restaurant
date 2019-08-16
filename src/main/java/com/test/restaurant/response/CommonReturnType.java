package com.test.restaurant.response;

public class CommonReturnType {
	
	private String status;//表明请求处理结果，"success"为成功
	
	private Object data;//如果status为200,则返回需要的对象，如果请求错误，则返回通用错误码格式
	
	public static CommonReturnType create(Object result) {
		return CommonReturnType.create(result,"success");
	}
	
	public static CommonReturnType create(Object result,String status) {
		CommonReturnType type = new CommonReturnType();
		type.setStatus(status);
		type.setData(result);
		return type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
}
