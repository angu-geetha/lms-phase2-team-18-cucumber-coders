Feature: Verify Search functionality in Program page
 Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks program button on the navigation bar  
    Then Admin should land on manage assignment page

  Scenario Outline: Validate valid search box function for Program
    Given Admin is on manage program page
    When Admin enters "<fieldName>" into search box  from "<dataKey>" and "<sheetName>"
    Then Displays entries with that "<fieldName>" from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey       		  	|sheetName						|fieldName		|
      | valid_program_name		|programSearchBox	    |name					|
      | valid_program_desc		|programSearchBox   	|desc					|
      | valid_program_status	|programSearchBox   	|status			  |




 Scenario Outline: Validate invalid search box function for Program
    Given Admin is on manage program page
    When Admin enters "<fieldName>" into search box  from "<dataKey>" and "<sheetName>"
    Then Displays empty details in the data table

    Examples: 
      | datakey       				|sheetName						|fieldName		|
      | invalid_program_name		|programSearchBox		|name					|
      | invalid_program_desc		|programSearchBox		|desc					|
      | invalid_program_duedate	|programSearchBox		|status		  	|
