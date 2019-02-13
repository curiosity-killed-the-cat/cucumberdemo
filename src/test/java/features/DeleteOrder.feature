Feature: User deletes an order
	Verify an order can update an order
		
		
Scenario: User deletes their order
		Given the user has placed an order
		When the user switches to the view orders form
		And the user deletes the order
		Then the order is removed from the system
		