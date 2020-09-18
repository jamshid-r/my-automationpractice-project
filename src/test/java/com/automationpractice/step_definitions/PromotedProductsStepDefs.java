package com.automationpractice.step_definitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.utilities.Driver;
import com.automationpractice.utilities.ExcelUtils;

import io.cucumber.java.en.Then;

public class PromotedProductsStepDefs {
	@Then("The promoted products should be displayed")
	public void the_promoted_products_should_be_displayed() {
		HomePage homepage = new HomePage();
		ExcelUtils sheet =  new ExcelUtils("src/test/resources/com/automationpractice/test_data/1.xlsx", "Sheet1");
	   List<Map<String, String>> allRows = sheet.getDataAsList();
	   
	   for (int i = 0; i < allRows.size(); i++) {
		   Map<String, String> row = allRows.get(i);
		   
		   if (row.get("Execute").equalsIgnoreCase("Y")) {
			   Assert.assertTrue(homepage.getProduct(row.get("Product")).isDisplayed());
			   
			
		}
		
	}
	}

	@Then("The details of the product should be correct")
	public void the_details_of_the_product_should_be_correct() {
		
		HomePage homepage = new HomePage();
		ProductPage pp = new ProductPage();
		ExcelUtils sheet =  new ExcelUtils("src/test/resources/com/automationpractice/test_data/1.xlsx", "Sheet1");
	   List<Map<String, String>> allRows = sheet.getDataAsList();
	   
	   for (int i = 0; i < allRows.size(); i++) {
		   Map<String, String> row = allRows.get(i);
		   if (row.get("Execute").equalsIgnoreCase("Y")) {
			   String expected_Product = row.get("Product");
			   
			   homepage.getProduct(expected_Product).click();

			   
			   String expected_price = row.get("Price");
			   String expected_Model = row.get("Model");
			   String expected_composition = row.get("Composition");
			   String expected_style = row.get("Styles");
			   
			   String actual_price = pp.price.getText();
			   String actual_model = pp.model.getText();
			   String actual_composition = pp.composition.getText();
			   String actual_style = pp.style.getText();
			   
			   
			   
			   Assert.assertTrue(expected_price.equals(actual_price));
			   Assert.assertTrue(expected_Model.equals(actual_model));
			   Assert.assertTrue(expected_composition.equals(actual_composition));
			   Assert.assertTrue(expected_style.equals(actual_style));
			   sheet.setCellData("Passed", "Status", i+1);

			   Driver.getDriver().navigate().back();
		}else {
			sheet.setCellData("Skipped", "Status", i+1);
		}
		
	}
	    
	}


}
