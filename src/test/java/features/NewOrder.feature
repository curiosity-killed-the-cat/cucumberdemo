Feature: User places an order
	Verify an order can be placed via the website
		
	Scenario: User places order
		Given the user is logged in
		And the user has loaded the order page
		And the user has completed the order form
		When the user clicks process
		Then the order will be added to the system
		