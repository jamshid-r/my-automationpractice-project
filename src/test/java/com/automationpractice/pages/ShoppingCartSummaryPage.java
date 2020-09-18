package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;



public class ShoppingCartSummaryPage {
	
	
	public ShoppingCartSummaryPage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//td[@class='cart_description']//p[@class='product-name']//a")
	public WebElement productName;
	
	
	@FindBy (xpath = "(//td[@class='cart_unit']//span[@class='price'])[2]")
	public WebElement unitPrice;
	
	@FindBy (xpath = "//input[@class='cart_quantity_input form-control grey']")
	public WebElement quantity;
	
	@FindBy (xpath = "//span[starts-with(@id,'total_product_price')]")
	public WebElement totalBefore;
	
	@FindBy (id = "total_price")
	public WebElement totalAfter;

	@FindBy (xpath = "//a[@title='Delete']")
	public WebElement delete;
}
