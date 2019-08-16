package com.test.restaurant.bean;

import java.math.BigDecimal;

public class OrderDetail {
    private Integer detailid;

	private Integer foodid;

	private Integer orderno;

	private Integer ordernum;

	private BigDecimal price;

	public Integer getDetailid() {
		return detailid;
	}

	public void setDetailid(Integer detailid) {
		this.detailid = detailid;
	}

	public Integer getFoodid() {
		return foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public Integer getOrderno() {
		return orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}