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
Feature: Program Page Verification
  
  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
  	
  	
  	Scenario Outline: Verify landing in manage program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see URL with "<UrlName>"

    Examples: 
      | UrlName                |
      | manageProgramHeader    |
      
      
    Scenario Outline: : Verify manage program page Header
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see header with "<UrlName>"

    Examples: 
      | UrlName    |
      | Assignment |
      
      
    Scenario Outline: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see disabled delete icon below the "<UrlName>"

    Examples: 
      | UrlName                |
      | manageProgramHeader |
      
    
    Scenario Outline: Verify search bar on the manage program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see search bar on the "<UrlName>"

    Examples: 
      | UrlName                |
      | manage program page |
      
    Scenario Outline: Verify add new program button on manage program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see "<AddNewButtonName>" button on the "<PageName>" page
  
    Examples: 
      | AddNewButtonName | PageName |
      | +Add New Program | Manage Program |
      
    Scenario Outline: Verify pagination icon and text below Manage Program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see text Showing x to y of z entries along with pagination icon on "<PageName>" page
  
    Examples: 
      | PageName |
      | Manage Program |
      
    Scenario Outline: Verify Footer text in Manage Program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see correct footer text on "<PageName>" page
  
    Examples: 
      | PageName |
      | Manage Program |
      
    Scenario Outline: Verify total number of records(5) displayed in Manage Program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see 5 records displayed on the "<PageName>" page
  
    Examples: 
      | PageName |
      | Manage Program |

  @tag1
  Scenario Outline: Manage Program Validation
    Given Admin is on Dashboard page after login
    When Admin clicks "<linksbutton>" on the navigation bar
    Then Admin should see url with "<UrlName>"
    And Admin should see heading with text "<Heading>" on the page
    And Admin should see text "Showing x to y of z entries" along with pagination icon below table
    And Admin should see footer as "In total there are z programs"
    And Admin should see Delete button on top left disabled by default
    And Admin should see "<newButton>" button above data table
    And Admin should see 5 records displayed on the "<linksbutton>" page
    And Admin should see datatable with column headers "detailed list"
    ## typically under table/tbody/tr/th 
    ## can we pass parameters as maps or hashtable? (Program Name, Program Description, Program Status, Edit,Delete
    And Admin should see sort icon beside columns header beside Edit and Delete
    And Admin should see checkbox on left side for all rows in the table
    And Admin should see Edit and Delete button on each row of data table
    And Admin should see search bar with text as Search
    
    Examples:
    |linksbutton | UrlName 			 | Heading 				| newButton 			|
    |Program 		 |Manage Program | Manage Program | + A New Program |
    
    Scenario Outline: Search Program with various parameters
    	Given Admin is on "<Manage Program>" page after login
    	When Admin enters "<searchphrase>" into the search box
    	Then Admin should see the programs displayed on the "<searchcriteria>"
    	
    	Examples:
    	|modulename			| Searchphrase |	searchcriteria	|
    	|Manage Program  |programname		| programname			|
    
    

  