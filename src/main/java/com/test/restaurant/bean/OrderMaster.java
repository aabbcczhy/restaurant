package com.test.restaurant.bean;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
    private Integer orderno;

	private Integer userid;

	private Byte status;

	private Date createtime;

	private BigDecimal ordersum;

	public Integer getOrderno() {
		return orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getOrdersum() {
		return ordersum;
	}

	public void setOrdersum(BigDecimal ordersum) {
		this.ordersum = ordersum;
	}

}