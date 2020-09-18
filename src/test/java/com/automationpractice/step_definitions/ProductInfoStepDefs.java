package com.automationpractice.step_definitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.utilities.Driver;
import com.automationpractice.utilities.LoggerUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductInfoStepDefs {

	Logger logger = LoggerUtils.getLogger(ProductInfoStepDefs.class);
	
	HomePage homePage = new HomePage();
	ProductPage productPage = new ProductPage();
	String actual;
	String expected;
	
	Integer globalTimes;
	
//	@When("I click on {string}")
//	public void i_click_on(String string) {
//	   homePage.getProduct(string).click();;
//	}
//
//	@Then("The product page should also display {string}")
//	public void the_product_page_should_also_display(String string) {
//	  actual = productPage.getProduct(string).getText();
//	  expected = string;
//	  
//	  Assert.assertEquals(expected, actual);
//
//	}
	
	@When("I click on the {string}")
	public void i_click_on_the(String string) {
		
		   homePage.getProduct(string).click();;

	   
	}

	@Then("The product page should also display {string} too")
	public void the_product_page_should_also_display_too(String string) {
		 actual = productPage.getProduct(string).getText();
		  expected = string;
		  
		  Assert.assertEquals(expected, actual);
	}

	@When("I land on {string} page")
	public void i_land_on_page(String string) {
	    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
	   
	}

	@When("I click on {string} button {int} times")
	public void i_click_on_plus_button_times(String word, Integer times) {
		for (int i = 0; i < times; i++) {
			if (word.equalsIgnoreCase("plus")) {
				productPage.plusButton.click();
				
			}else {
				productPage.minusButton.click();
			}	
			
			
		}
		globalTimes = times+1;
		System.out.println(productPage.quantityBox.getAttribute("value"));
		
	   
	}

	@Then("The quantity should be correct")
	public void the_quantity_should_be_correct() {
		
	
		actual = productPage.quantityBox.getAttribute("value");
	    Assert.assertEquals(globalTimes.toString(), actual);
	}

//	@Then("I click on {string} button {int} times")
//	public void i_click_on_minus_button_times(String word, Integer times) {
//		expected = times.toString();
//		for (int i = globalTimes; i > times; i--) {
//			productPage.minusButton.click();
//		}
//		System.out.println(productPage.quantityBox.getAttribute("value"));
	    
//	}
	@When("I click on  {string}")
	public void i_click_on(String string) {
	  HomePage hp = new HomePage();
	  hp.getProduct(string).click();
	}

	@Then("The product page should also display  {string}")
	public void the_product_page_should_also_display(String string) {
	   ProductPage pp = new ProductPage();
	   String actual = pp.getProduct(string).getText();
	   String expected = string;
	   Assert.assertTrue(actual.contains(expected));
	}

	@Then("The product price should be  {double}")
	public void the_product_price_should_be(Double double1) {
		   ProductPage pp = new ProductPage();
		  String expected = double1.toString();
		  String actual = pp.getPrice(double1).getText();
		  System.out.println("actual is "+actual+"     expected is "+expected);
		  
		   Assert.assertTrue(actual.contains(expected));

	}



	
}
