Feature: Verify shopping cart


	Scenario: Verify shopping cart details
	
		Given I am on the homepage
		When I click on "Faded Short Sleeve T-shirts"
		And  I increase the quantity to 5 and add them to cart
		Then  The shopping cart details have to be as following
				|Description                | Unit price |  Quantity| Product Total| Total After Fees|
				|Faded Short Sleeve T-shirts| $16.51     | 5        | $82.55       | $84.55          |
		
		
		@temp
	Scenario Outline: Verify shopping cart details for all products
	
		Given I am on the homepage
		When I click on "<product>"
		And  I increase the quantity to <quantity> and add them to cart
		Then  The shopping cart details have to be as following
				| Description					| Unit price   | Quantity    | Product Total  | Total After Fees  |
				|<product>		        | <price>      |  <quantity> | <totalBefore>| <totalAfter>        |
		
		
				Examples:
				|product                    | price      |  quantity| totalBefore  | totalAfter      |
				|Faded Short Sleeve T-shirts| $16.51     | 5        | $82.55       | $84.55          |
				|Blouse											| $27.00     | 5        | $135.00      | $137.00         |
				|Printed Dress              | $26.00     | 5        | $130.00      | $132.00         |												