package com.test.restaurant.bean;

import java.math.BigDecimal;

public class Menu {
    private Integer foodid;

	private String foodname;

	private String pictureurl;

	private BigDecimal price;

	private Byte status;

	public Integer getFoodid() {
		return foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname == null ? null : foodname.trim();
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl == null ? null : pictureurl.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}