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
      
   Scenario Outline: Verify delete icon below the Manage Program header
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see disabled delete icon below the "<UrlName>"

    Examples: 
      | UrlName                |
      | manageProgramHeader |

  Scenario Outline: Verify search bar on the manage Program page with search text as "Search..."
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see search bar on the "<UrlName>"

    Examples: 
      | UrlName                |
      | manage program page |
      
    Scenario Outline: Verify data table for column headers on the manage program page
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see data table on the manage program page With following column headers "<sheetName>" with "<dataKey>"
		 Examples: 
      | dataKey | sheetName|
      | validate_column_headers |program|
      
    Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available for "Program"
  
   Scenario: Verify Delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available for "Program"
    
  Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see check box in the all rows  of data table when entries available
    
  Scenario: Verify sort icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete
    
  Scenario Outline: Verify pagination has Next page link
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see the pagination has Next link in "<module>" Page
     Examples: 
      | module       |
      | Program |
    
    
  Scenario Outline: Verify Next page link is disabled on clicking last page record
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see next page link disabled on clicking last page record in "<module>" Page
    Examples: 
      | module       |
      | Program |
    
    Scenario Outline: Verify pagination has Previous page link
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see the pagination has Previous link in "<module>" Page
    Examples: 
      | module       |
      | Program |
    
    Scenario Outline: Verify Admin can see previous link disabled on clicking first page record
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see previous page link disabled on clicking first page record in "<module>" page
    Examples: 
      | module       |
      | Program |
  
  Scenario Outline: Verify Admin can navigate from Program page to other pages
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should get redirected to "<module>" page
    Examples: 
      | module     |
      | Student    |
      | Batch      |
      | Class      |
      | User       |
      | Assignment |
      | Attendance |
      | Logout     |
      
   Scenario Outline: Verify if Program link is broken
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Admin should see if the link is broken for "<module>" page

    Examples: 
 			| module     |
      | Program     |
      
    
      
      
   
      
      

  