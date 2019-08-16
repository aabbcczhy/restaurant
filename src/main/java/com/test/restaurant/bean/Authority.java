package com.test.restaurant.bean;

public class Authority {
    private Integer authorityid;

	private String authorityname;

	private String description;

	public Integer getAuthorityid() {
		return authorityid;
	}

	public void setAuthorityid(Integer authorityid) {
		this.authorityid = authorityid;
	}

	public String getAuthorityname() {
		return authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname == null ? null : authorityname.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}