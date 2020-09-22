package com.automationpractice.step_definitions;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import com.automationpractice.beans.ShoppingCart;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ShoppingCartStepDefs {
	
	
	Logger logger  = Logger.getLogger(ShoppingCartStepDefs.class);
	HomePage hp = new HomePage();
	ProductPage pp = new ProductPage();
	ShoppingCartSummaryPage sp = new ShoppingCartSummaryPage();
	
	@When("I click on {string}")
	public void i_click_on(String string) {
	    hp.getProduct(string).click();
	}

	@When("I increase the quantity to {int} and add them to cart")
	public void i_increase_the_quantity_to_and_add_them_to_cart(Integer int1) {
	   for (int i = 0; i < int1-1; i++) {
		pp.plusButton.click();
	}
	   pp.addToCartButton.click();
	   pp.proceed.click();
		
	}

	@Then("The shopping cart details have to be as following")
	public void the_shopping_cart_details_have_to_be_as_following(List<ShoppingCart>cart) {
		
		for (int i = 0; i < cart.size(); i++) {
			ShoppingCart item = cart.get(i);
			
			String expectedProductName = item.getDescription();
			String expectedUnitPrice = item.getUnitPrice();
			String expectedQuantity = item.getQuantity();
			String expectedTotalBefore = item.getTotalBefore();
			String expectedTtalAfter = item.getTotalAfter()+"asd";
		
		
		
	    String actualProductName = sp.productName.getText();
	    String actualUnitPrice = sp.unitPrice.getText();
	    String actualQuantity = sp.quantity.getAttribute("value");
	    String actualTotalBefore = sp.totalBefore.getText();
	    String actualTotalAfter = sp.totalAfter.getText();
	    
	    Assert.assertEquals(expectedProductName, actualProductName);
	    Assert.assertEquals(expectedUnitPrice, actualUnitPrice);
	    Assert.assertEquals(expectedQuantity, actualQuantity);
	    Assert.assertEquals(expectedTotalBefore, actualTotalBefore);
	    Assert.assertEquals(expectedTtalAfter, actualTotalAfter);
	    
	    sp.delete.click();
	    Driver.getDriver().navigate().back();
	    Driver.getDriver().navigate().back();

	   } 
		logger.info("Verifying shopping cart details");
	}



}
