#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Assignment.feature


Background: Admin is Logged In LMS portal
	Given Admin is in login page
	When Admin enter valid credentials  and clicks login button 
	Then Admin should land on dashboard page

Scenario Outline: Verify landing in manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see URL with "<UrlName>"
Examples:
|linksbutton |UrlName          |
|assignment  |Manage assignment|


 Scenario Outline: Capture the response time to navigate to manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Get the response time for navigation from dashboard page to manage assignment page
	Examples:
|linksbutton      |
|assignment       |
	
	
Scenario Outline: Verify manage assignment page Header
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see header with "<UrlName>"
	Examples:
|linksbutton |UrlName|
|assignment  |Manage assignment|



	Scenario Outline: Validate text in manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar and get all text from the portal page
	Then Admin should see correct spelling for the all the fields
		Examples:
|linksbutton      |
|assignment       |
	
		Scenario Outline: Verify delete icon below the header
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see disabled delete icon below the "<UrlName>"
		Examples:
|linksbutton |UrlName|
|assignment  |Manage assignment|


		Scenario Outline: Verify search bar on the manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see search bar on the manage assignment page
		Examples:
|linksbutton      |
|assignment       |
	
	Scenario Outline: Verify add new assignment button  on manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see +Add New assignment button on the manage assignment page
	Examples:
|linksbutton      |
|assignment       |
	
	
	Scenario Outline: Verify data table on the manage assignment page
	Given Admin is on dashboard page after Login
	When Admin clicks "<linksbutton>" button on the navigation bar
	Then Admin should see data table on the manage assignment page With following column headers "<Columnheaders>"
	
	Examples:
	|linksbutton      |Columnheaders         |
  |assignment       | check box symbol     |
	|assignment       | Assignment name      |
	|assignment       |Assignment description|
	|assignment       |Assignment Date       |
	|assignment       |Assignment Grade      |
	|assignment       |Edit                  |
	|assignment       |Delete                |
	                  
	                  
	                  
