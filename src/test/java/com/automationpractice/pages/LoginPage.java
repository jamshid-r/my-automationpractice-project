package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class LoginPage {
	public LoginPage() {
	PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "email")
	public WebElement emailBox;
	
	@FindBy(id = "passwd")
	public WebElement passwordBox;
	
	@FindBy(id = "SubmitLogin")
	public WebElement signInButton;
	
	@FindBy(id = "email_create")
	public WebElement createEmailBox;
	
	@FindBy (id = "SubmitCreate")
	public WebElement createAccountButton;
	
	

}
