package com.automationpractice.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;


public class Hooks {
	

	
	
	
	
	
	@Before ()
	public void setUp() {
		
		Driver.getDriver().manage().timeouts().implicitlyWait(
				(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout"))), TimeUnit.SECONDS);
//		Driver.getDriver().manage().window().maximize();
//

	}
	
	@Before ("@db")
	public void setUpDB() {
		DatabaseUtils.createConnection();

}
	
	
	
	@After()
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			String failedscr = "scr";
			scenario.embed(screenshot, "image/png", failedscr );
					}
		Driver.closeDriver();
	}

	
	@After ("@db")
	public void tearDownDatbse() {

		DatabaseUtils.close();
		
		
	}


}
