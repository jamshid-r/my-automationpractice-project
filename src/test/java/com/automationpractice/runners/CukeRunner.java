 package com.automationpractice.runners;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith (Cucumber.class)
@CucumberOptions (
		
		plugin = {"pretty",
				"html:target/built-in-html-report",
				"json:target/Cucumber.json "
		
		},
					

		tags = "@temp",//"@db",//"@excel", //"@db",  "@smoke and @test"
		features = "src/test/resources/com/automationpractice/features",
		glue = "com/automationpractice/step_definitions"
		,strict = true
//		,dryRun = true 
		,monochrome =true
		,stepNotifications = true
//		,snippets = SnippetType.CAMELCASE
		)
public class CukeRunner {

} 
