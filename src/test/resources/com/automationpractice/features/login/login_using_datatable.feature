Feature: Login functionality using datatables
		
		Background: 
			Given I am on the homepage
			When I click on Sign in


	@test 
Scenario: Verify positive login using DataTable
			
			Then I enter the following credentials, I should be able to login
					|duotech@gmail.com  | dt123      |
					|dt2020@gmail.com   | dt123      |
					|akmaldt@gmail.com  | dt123      |
#					|duotech1@gmail.com | duotech1   |
#					|duotech2@gmail.com | duotech22  |
#					|duotech3@gmail.com | duotech333 |

	Scenario: Verify user registration
			
			
			Then I enter valid email and click Create Account, I should be able to pass the following data and click on register and see the name
					|First Name  | Last Name  | Address            | Password | City   |  Zip  |  Phone     |
					|John        | Smith      | 8133 Leesburg Pike | dt12345  | Vienna | 22812 | 2021234567 |
					|Jane        | Adams      | 9087 Main Street   | dt12345  | Vienna | 22812 | 2043034567 |
				
			
