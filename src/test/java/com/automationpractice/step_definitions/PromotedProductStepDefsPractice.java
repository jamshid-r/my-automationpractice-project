package com.automationpractice.step_definitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.utilities.Driver;
import com.automationpractice.utilities.ExcelUtils;

import io.cucumber.java.en.Then;

public class PromotedProductStepDefsPractice {
	HomePage hp = new HomePage();
	ExcelUtils file = new ExcelUtils("src/test/resources/com/automationpractice/test_data/1.xlsx", "Sheet1");
	String expected;
	String actual;
	@Then("The promoted products must be displayed")
	public void the_promoted_products_must_be_displayed() {
		List<Map<String, String>> list = file.getDataAsList();
		for (Map<String, String> map : list) {
			if (map.get("Execute").equalsIgnoreCase("Y")) {
				expected = map.get("Product");
				Assert.assertTrue(hp.getProduct(expected).isDisplayed());
				
			}
			
		}
	    
	}

	@Then("The details of the product must be correct")
	public void the_details_of_the_product_must_be_correct() {
	   List<Map<String, String>> allRows = file.getDataAsList();
	   for (int i = 0; i < allRows.size(); i++) {
		   Map<String, String> map = allRows.get(i);
		
	
		   if (map.get("Execute").equalsIgnoreCase("Y")) {
			   String expectedPrice = map.get("Price");
			   String expectedModel = map.get("Model");
			   String expectedComposition = map.get("Composition");
			   String expectedStyles = map.get("Styles");
			   
			   hp.getProduct(map.get("Product")).click();
			   ProductPage pp = new ProductPage();
			   
			   String actualPrice = pp.price.getText();
			   String actualModel = pp.model.getText();
			   String actualComposition = pp.composition.getText();
			   String actualStyles = pp.style.getText();
			   
			   Assert.assertEquals(expectedPrice, actualPrice);
			   Assert.assertEquals(expectedModel, actualModel);
			   Assert.assertEquals(expectedComposition, actualComposition);
			   Assert.assertEquals(expectedStyles, actualStyles);

			   file.setCellData("Passed", "Status", i+1);
			   
			   Driver.getDriver().navigate().back();
			
		}else {
			file.setCellData("Failed", "Status", i+1);
		}
		
	}
	}


}
