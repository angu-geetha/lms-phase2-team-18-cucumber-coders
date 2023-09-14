
Feature: UserPage Validation
  
  
   Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
  	
  	
  	Scenario Outline: Verify landing in manage user page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see URL with "<UrlName>"

    Examples: 
      | UrlName                |
      | manageUserHeader    |
      
      
    Scenario Outline: : Verify manage user page Header
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see header with "<UrlName>"

    Examples: 
      | UrlName    |
      | User |
      
    Scenario Outline: Verify pagination icon and text below Manage User page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see text Showing x to y of z entries along with pagination icon on "<PageName>" page
  
    Examples: 
      | PageName |
      | Manage User |
      
      
       Scenario Outline: Verify pagination has Next page link
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see the pagination has Next link in "<module>" Page
     Examples: 
      | module       |
      | User |
    
    
    
  Scenario Outline: Verify Next page link is disabled on clicking last page record
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see next page link disabled on clicking last page record in "<module>" Page
    Examples: 
      | module       |
      | User |
    
    Scenario Outline: Verify pagination has Previous page link
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see the pagination has Previous link in "<module>" Page
    Examples: 
      | module       |
      | User |
    
    Scenario Outline: Verify Admin can see previous link disabled on clicking first page record
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see previous page link disabled on clicking first page record in "<module>" page
    Examples: 
      | module       |
      | User |
  
   Scenario Outline: Verify data table for column headers on the manage user page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see data table on the manage user page With following column headers "<sheetName>" with "<dataKey>"
		 Examples: 
      | dataKey | sheetName|
      | validate_column_headers |user|
      
    Scenario: Verify Delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available for "User" 
    
    Scenario Outline: Verify add new program button on manage program page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see "<AddNewButtonName>" button on the "<PageName>" page
  
    Examples: 
      | AddNewButtonName | PageName |
      | +Add New User | Manage User |
      
    Scenario Outline: Verify add new staff button on manage user page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see "Add New Staff" button on the manage User page
  
    Examples: 
      | AddNewButtonName | PageName |
      | +Add New Staff | Manage User |
      
      
    Scenario Outline: Verify search bar on the manage user page
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see search bar on the "<UrlName>"

    Examples: 
      | UrlName                |
      | manage user page |
      
    Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see check box in the all rows  of data table when entries available
    
    Scenario: Verify Edit icon in the data table is enabled
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available for "User"
  
   Scenario: Verify Delete icon in the data table is enabled
    Given Admin is on dashboard page after Login
    When Admin clicks program button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available for "User"
    
    Scenario Outline: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks user button on the navigation bar
    Then Admin should see disabled delete icon below the "<UrlName>"

    Examples: 
      | UrlName                |
      | manageUserHeader |
      
      
      
      
      
      
      