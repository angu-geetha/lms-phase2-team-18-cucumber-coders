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
    And Admin clicks assignment button on the navigation bar
    And Admin clicks + add new  button on manage assignment page
    Then Admin should see a popup  with  heading "Assignment details"

    

  Scenario Outline: Validate admin able to add new assignment with mandatory or optional feilds
    Given Admin is in  assignment details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Admin should see new assignment details is added in the data table from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey              | sheetName           |
      | mandatory_valid      | assignmentSearchBox |
      | valid_data_allfields | assignmentSearchBox |

  Scenario Outline: Validate admin able to add new assignment with invalid data
    Given Admin is in  assignment details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Error message should appear in alert

    Examples: 
      | datakey                   | sheetName           |
      | mandatory_invalid         | assignmentSearchBox |
      | invalidData_optionalField | assignmentSearchBox |

  Scenario Outline: Validate admin able to add new assignment with missing data
    Given Admin is in  assignment details popup window
    When Admin enters data for add|edit assignment from "<dataKey>" and "<sheetName>"
    Then Error message with "<message>" should be displayed from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey                | sheetName           | message                                          |
      | missing_ProgramName    | assignmentSearchBox | Program Name is missing                          |
      | missing_batchNo        | assignmentSearchBox | Batch number is missing                          |
      | missing_assignmentName | assignmentSearchBox | Assignment name is missing                       |
      | missing_dueDate        | assignmentSearchBox | Assignment due date is missing                   |
      | missing_gradeBy        | assignmentSearchBox | Grade by is missing                              |
      | invalid_passedDate     | assignmentSearchBox | Assignment cannot be created for the passed date |
