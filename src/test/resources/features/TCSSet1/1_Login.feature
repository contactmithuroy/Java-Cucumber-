@login @homepage
Feature: Testing Homepage Items and Login Related test cases 

Background:
	Given Validate User landed on homepage
@TC_001 @smoke
Scenario: Verify user landed on Homepage and UserID is available
	Then Verify UserID is Visible 
		
@TC_002 @smoke
Scenario: Verify Password input is available
	Then Verify Password Input is Visible

@TC_003 @smoke
Scenario: Verify LOGIN is available
	Then Verify LOGIN is visible 

@TC_004 @smoke
Scenario: Verify Table Demo is available
	Then Click on Selenium Drop down from the top
	Then Verify Table Demo is available Under Selenium Drop down


				