
@tag
Feature: Verify Edit functionality of Program Page


  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks program button on the navigation bar 
    And Admin clicks Edit button in data table for "Program"
    Then Admin should see a popup  with  heading "Program details"

    
 
    Scenario Outline: Validate admin able to edit program with mandatory or optional fields
    Given Admin is in  program details popup window
    When Admin enters data for add|edit program from "<dataKey>" and "<sheetName>"
    Then Admin should see new program details is added in the data table from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey              | sheetName           |
      | mandatory_valid      | programSearchBox |
      | valid_data_allfields | programSearchBox |

  Scenario Outline: Validate admin able to edit existing program with invalid data
    Given Admin is in  program details popup window
    When Admin enters data for add|edit program from "<dataKey>" and "<sheetName>"
    Then Error message should appear in alert of "Program" page

    Examples: 
      | datakey                   | sheetName           |
      | mandatory_invalid         | programSearchBox |
      | invalidData_optionalField | programSearchBox |


  Scenario Outline: Validate admin able to add new program with missing data
    Given Admin is in  program details popup window
    When Admin enters data for add|edit program from "<dataKey>" and "<sheetName>"
    Then Error message with "<message>" should be displayed from "<dataKey>" and "<sheetName>" from "<page>" page

    Examples: 
     | datakey               		 | sheetName          	| message                        |
      | missing_ProgramName    		 | programSearchBox 	  | Name is required               |
      | missing_ProgramDesc   		 | programSearchBox 	  | Description is required        |
      | missing_ProgramAndDesc 		 | programSearchBox     | Name and Description required  |
      | specialchar_ProgramAndDesc | programSearchBox     | Enter Valid Name and Desc      |
      | blankdata                  | programSearchBox		  | Name is mandatory              |
      
    Scenario Outline: Validate admin able to see the success message after adding a new program
    Given Admin is in  program details popup window
    When Admin enters data for add|edit program from "<dataKey>" and "<sheetName>"
    Then Admin should see "<successUpdateMessage>"  alert message
 		Examples: 
      | datakey              | sheetName        | successUpdateMessage |
      | mandatory_valid      | programSearchBox | Successful Program updated |
      | valid_data_allfields | programSearchBox | Successful Program updated |
    