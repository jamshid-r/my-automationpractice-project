Feature: Product description
	
Scenario: Verify product name
	
	

	Given I am on the homepage
	When I click on "Blouse"
	Then The product page should also display "Blouse"


	Scenario: Verify product name
	
	

	Given I am on the homepage
	When I click on "Printed Dress"
	Then The product page should also display "Printed Dress"
	
	
	Scenario Outline: Verify product name
	
	

	Given I am on the homepage
	When I click on the "<Product>"
	Then The product page should also display "<Product>" too
	
	Examples:
	|Product										|
	|Blouse											|
	|Printed Dress							|
	|Faded Short Sleeve T-shirts|
	|Printed Summer Dress				|
	|Printed Chiffon Dress			|
	

		Scenario: Verify plus and minus buttons
		
			Given I am on the homepage
			When I click on "Blouse"
			And I land on "product" page
			When I click on "plus" button 15 times
			Then The quantity should be correct
			And I click on "minus" button 11 times
			Then The quantity should be correct
			
	