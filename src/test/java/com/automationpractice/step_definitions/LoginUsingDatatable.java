package com.automationpractice.step_definitions;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.automationpractice.beans.User;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.utilities.LoggerUtils;
import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class LoginUsingDatatable {
	
	Logger logger = LoggerUtils.getLogger(LoginUsingDatatable.class);
	
	@Then("I enter the following credentials, I should be able to login")
	public void i_enter_the_following_credentials_I_should_be_able_to_login(Map<String, String>str) {
	    
		LoginPage lp = new LoginPage();
		
		Set<Entry<String, String>> entrySet = str.entrySet();
		for(Entry<String, String>entry : entrySet) {
			String email = entry.getKey();
			String password = entry.getValue();
			lp.emailBox.sendKeys(email);
			lp.passwordBox.sendKeys(password);
			lp.signInButton.click();
			
			MyAccountPage mp = new MyAccountPage();
			String expected = "Welcome to your account. Here you can manage all of your personal information and orders."; 
			String actual = 	mp.welcomeMessage.getText();
			Assert.assertEquals(expected, actual);
			
			mp.logOutLink.click();
		}
		
	}

	


	@Then ("I enter valid email and click Create Account, I should be able to pass the following data and click on register and see the name")
	public void i_enter_valid_email_and_click_Create_Account_i_should_be_able_to_pass_the_following_data_and_click_on_register_and_see_the_name(List<User>users) {
		for (User user : users) {
		LoginPage loginPage = new LoginPage();
		
		loginPage.createEmailBox.sendKeys(new Faker().internet().emailAddress());
		loginPage.createAccountButton.click();
		
		CreateAccountPage cp = new CreateAccountPage();
		
			cp.firstName.sendKeys(user.getFirstName());
			cp.lastName.sendKeys(user.getLastName());
			cp.password.sendKeys(user.getPassword());
			cp.selectDOB();
			cp.address.sendKeys(user.getAddress());
			cp.city.sendKeys(user.getCity());
			cp.selectState();
			cp.zip.sendKeys(user.getZip());
			cp.phoneNo.sendKeys(user.getPhone());
			
			
			cp.registerButton.click();
			
			MyAccountPage mp = new MyAccountPage();
						System.out.println(mp.customerName.getText());

//			String actual = mp.customerName.getText();
//			String expected = user.getFirstName()+" "+user.getLastName();
//			Assert.assertEquals(expected, actual);
			mp.logOutLink.click();
		
		}
		
			
		}

			}



