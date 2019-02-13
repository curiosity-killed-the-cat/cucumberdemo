Feature: Logout of website
	Verify the logout link terminates the session
		
	Scenario: User logs out
		Given the user is logged in
		When the user clicks logout
		Then the login screen is shown
		