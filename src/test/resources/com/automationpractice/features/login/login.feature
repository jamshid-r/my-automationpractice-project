

Feature: Login functionality

	Background: 
		Given I am on the homepage
		When I click on Sign in

  @logging
  Scenario: Verify login page title
   
   	Then 	The login page title should be Login - My Stora

	
	Scenario:
		
		Then I should be able to see emal, password boxes and login button;
  
  
  Scenario: Verify positive login
	
		And I enter djamshid.r@gmail.com as email, dr123 as password, and click on login;
		Then I should be able to land on welcome page and read welcome message;
		
	  
		Scenario: Verify positive login using parametrization first
			
			And I enter "djamshid.r@gmail.com" as email, "dj123" as password, and click login
			Then I should be able to land on welcome page and read welcome message;
		
	
		Scenario: Verify positive login using parametrization second
			
			And I enter "akmaldt@gmail.com" as email, "dt123" as password, and click login
			Then I should be able to land on welcome page and read welcome message;
		
		
	Scenario: Verify positive login using parametrization third
			
			And I enter "duotech@gmail.com" as email, "dt123" as password, and click login
			Then I should be able to land on welcome page and read welcome message;
				
		
		
		
		
		