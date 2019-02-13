Feature: User updates an order
	Verify a user can update an order
		
	Scenario: User updates their order
		Given the user has placed an order
		When the user switches to the view orders form
		And the user updates the order using the form
		Then the order is updated
		