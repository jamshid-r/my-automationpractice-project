package com.automationpractice.beans;

public class ShoppingCart {
	
	private String description;
	private String unitPrice;
	private String quantity;
	private String totalBefore;
	private String totalAfter;
	public ShoppingCart(String description, String unitPrice, String quantity, String totalBefore, String totalAfter) {
		super();
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalBefore = totalBefore;
		this.totalAfter = totalAfter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotalBefore() {
		return totalBefore;
	}
	public void setTotalBefore(String totalBefore) {
		this.totalBefore = totalBefore;
	}
	public String getTotalAfter() {
		return totalAfter;
	}
	public void setTotalAfter(String totalAfter) {
		this.totalAfter = totalAfter;
	}
	
	

}
