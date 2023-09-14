Feature: Verify Program - Add/Edit functionality

  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And Admin clicks program button on the navigation bar
    And Admin clicks + add new  button on manage program page
    Then Admin should see a popup  with  heading "Program details"

    

  Scenario Outline: Validate admin able to add new program with mandatory or optional feilds
    Given Admin is in  program details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Admin should see new program details is added in the data table from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey              | sheetName           |
      | mandatory_valid      | programSearchBox |
      | valid_data_allfields | programSearchBox |
      
      
   Scenario Outline: Validate admin able to add new program with invalid data
    Given Admin is in  program details popup window

    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"

    Then Error message should appear in alert of "Program" page

    Examples: 
      | datakey                   | sheetName           |
      | mandatory_invalid         | programSearchBox |
      | invalidData_optionalField | programSearchBox |
      
    
    Scenario Outline: Validate admin able to add new program with missing data
    Given Admin is in  program details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Error message with "<message>" should be displayed from "<dataKey>" and "<sheetName>" from "<page>" page

    Examples: 
      | datakey               		 | sheetName          	| message                        | page |
      | missing_ProgramName    		 | programSearchBox 	  | Name is required               |Program|
      | missing_ProgramDesc   		 | programSearchBox 	  | Description is required        |Program|
      | missing_ProgramAndDesc 		 | programSearchBox     | Name and Description required  |Program|
      | specialchar_ProgramAndDesc | programSearchBox     | Enter Valid Name and Desc      |Program|
      | blankdata                  | programSearchBox		  | Name is mandatory              |Program|
      
   
    Scenario Outline: Validate admin able to see the success message after adding a new program
    Given Admin is in  program details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Admin should see "<successMessage>"  alert message
 		Examples: 
      | datakey              | sheetName        | successMessage |
      | mandatory_valid      | programSearchBox | Successful Program created |
      | valid_data_allfields | programSearchBox | Successful Program created |
      
      
    Scenario: Validate admin able to see the success message after adding a new program
    Given Admin is in  program details popup window
    When Admin clicks close icon on Program details form
    Then Admin should see Program Details popup window closed without saving
 		
    

    