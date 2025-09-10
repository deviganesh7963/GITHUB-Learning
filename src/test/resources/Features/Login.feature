Feature: To test Login function

@Login
Scenario Outline: Verify login successful with valid credentials

	Given User is in login page 
	When user enters <username> and <password>
	And Click on login button
	Then User navigated to Homepage

	Examples:
	 | username | | password |
	 | Admin | | admin123 |
	 | Admin1 | | admin1234 |
	