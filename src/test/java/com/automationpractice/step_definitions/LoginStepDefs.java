package com.automationpractice.step_definitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.Driver;
import com.automationpractice.utilities.LoggerUtils;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	
	Logger logger = LoggerUtils.getLogger(LoginStepDefs.class);
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
	    Driver.getDriver().get(ConfigReader.getConfiguration("url"));
	    logger.info("Navigating to a homepage");
	}

	@When("I click on Sign in")
	public void i_click_on_Sign_in() {
	    HomePage homepage = new HomePage();
	    logger.info("Clicking on Sign in");
	    homepage.signInLink.click();
	}

	@Then("The login page title should be Login - My Stora")
	public void the_login_page_title_should_be_Login_My_Stora() {
	   logger.info("Getting the page title");
	   String actual = Driver.getDriver().getTitle();
	   String expected = "Login - My Stora";
	   logger.info("Verifying the title");
	   
	   Assert.assertEquals(expected, actual);
	}
	
	@Then("I should be able to see emal, password boxes and login button;")
	public void i_should_be_able_to_see_emal_password_boxes_and_login_button() {
	   
		LoginPage loginPage = new LoginPage();
		loginPage.emailBox.isDisplayed();
		loginPage.passwordBox.isDisplayed();
		loginPage.signInButton.isDisplayed();
		
	}
	
	@When("I enter djamshid.r@gmail.com as email, dr123 as password, and click on login;")
	public void i_enter_duotech_gmail_com_as_email_dt123_as_password_and_click_on_login() {
	    LoginPage loginPage = new LoginPage();
	    loginPage.emailBox.sendKeys("djamshid.r@gmail.com");
	    loginPage.passwordBox.sendKeys("dj123");
	    loginPage.signInButton.click();
	}

	@Then("I should be able to land on welcome page and read welcome message;")
	public void i_should_be_able_to_land_on_welcome_page_and_read_welcome_message() {
	   String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
	   MyAccountPage myAccountPage = new MyAccountPage();
	   
	   String actual = myAccountPage.welcomeMessage.getText(); 
	   Assert.assertEquals(expected, actual);
	}
	
	@When("I enter {string} as email, {string} as password, and click login")
	public void i_enter_as_email_as_password_and_click_login(String email, String password) {
		 LoginPage loginPage = new LoginPage();
		    loginPage.emailBox.sendKeys(email);
		    loginPage.passwordBox.sendKeys(password);
		    loginPage.signInButton.click();     
	}


}
