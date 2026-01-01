@login @homepage
Feature: Testing Homepage Items and Login Related test cases 

Background:
	Given Validate User landed on homepage
	
@TC_001 @smoke
Scenario: Verify user landed on Homepage and UserID is available
	Then Verify "UserID" is visible 
		
@TC_002 @smoke
Scenario: Verify Password input is available
	Then Verify "Password" is visible

@TC_003 @smoke
Scenario: Verify LOGIN is available
	Then Verify LOGIN is _004 @smoke
Scenario: Verify Table Demo is available
	Then Click on Selenium Drop down from the top
	Then Verify Table Demo is available Under Selenium Drop down

#Invalid user id and Invalid Password
@TC_005
Scenario:Verify Verify logging in with invalid credentials in Login Homapage(both invalid)
	Given Pass "mngr6467" on "UserID" Field
	And Pass "000000" on "Password" Field
	Then Click on Login button
	Then Click on "OK" button from the alert

#Valid user id and invalid password
@TC_006
Scenario:Verify Verify logging in with invalid credentials in Login Homapage(both invalid)
	Given Pass "mngr646768" on "UserID" Field
	And Pass "000000" on "Password" Field
	Then Click on Login button
	Then Click on "OK" button from the alert

#Invalid user id and valid password
@TC_007
Scenario:Verify Verify logging in with invalid credentials in Login Homapage(both invalid)
	Given Pass "mngr6467" on "UserID" Field
	And Pass "nebEsAg" on "Password" Field
	Then Click on Login button
	Then Click on "OK" button from the alert
				