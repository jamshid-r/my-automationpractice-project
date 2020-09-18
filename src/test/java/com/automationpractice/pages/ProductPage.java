package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class ProductPage {
	
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	public WebElement getProduct(String name) {
		
		String myXpath = "//h1[contains(text(),'"+name+"')]";
		return Driver.getDriver().findElement(By.xpath(myXpath));
		
	}
	@FindBy (xpath = "//i[@class='icon-plus']")
	public WebElement plusButton;
	
	@FindBy (className = "icon-minus")
	public WebElement minusButton;
	
	@FindBy(id = "quantity_wanted")
	public WebElement quantityBox;
	
	public WebElement getPrice(double price) {
		String myXpath = "//span[contains(text(),'"+price+"')]" ;
		return Driver.getDriver().findElement(By.xpath(myXpath));
		
	}
	@FindBy (xpath = "//span[@id='our_price_display']")
	public WebElement price;

	@FindBy (xpath = "//span[@itemprop='sku']")
	public WebElement model;
	
	@FindBy (xpath = "//tr[@class='odd']//td[2]")
	public WebElement composition;
	
	@FindBy (xpath = "//tr[@class='even']//td[2]")
	public WebElement style;
	
	@FindBy (xpath = "//p[@id='add_to_cart']//button[@type='submit']")
	public WebElement addToCartButton;

	@FindBy (xpath = "//span[contains(text(),'Proceed to checkout')]")
	public WebElement proceed;
}
