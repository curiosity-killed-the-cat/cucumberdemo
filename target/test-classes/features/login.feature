Feature: Login to website
	Verify the user is able to login to the website with valid credentials
	
#	Scenario: Login as an authenticated user
#		Given the user is on the login screen
#		When the user enters their username and password
#		And clicks the login button
#		Then the user is logged in
		
	Scenario: User loggs out
		Given Given the user is logged in
		When the user clicks logout
		Then the login screen is shown
		