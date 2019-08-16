package com.test.restaurant.bean;

public class Managerpassword {
    private Integer id;
    
    private Integer managerid;

	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	
	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

}