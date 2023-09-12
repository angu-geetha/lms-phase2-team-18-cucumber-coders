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
    And  Admin clicks assignment button on the navigation bar  
    Then Admin should land on manage assignment page

  Scenario Outline: Validate valid search box function for Assignment
    Given Admin is on manage assignment page
    When Admin enters "<feildName>" into search box  from "<dataKey>" and "<sheetName>"
    Then Displays entries with that "<feildName>" from "<dataKey>" and "<sheetName>"

    Examples: 
      | datakey       			|sheetName						|feildName		|
      | valid_assgn_name		|assignmentSearchBox	|name					|
      | valid_assgn_desc		|assignmentSearchBox	|desc					|
      | valid_assgn_duedate	|assignmentSearchBox	|dueDate			|
      | valid_assgn_grade		|assignmentSearchBox	|grade				|



 Scenario Outline: Validate invalid search box function for Assignment
    Given Admin is on manage assignment page
    When Admin enters "<feildName>" into search box  from "<dataKey>" and "<sheetName>"
    Then Displays empty details in the data table

    Examples: 
      | datakey       				|sheetName						|feildName		|
      | invalid_assgn_name		|assignmentSearchBox	|name					|
      | invalid_assgn_desc		|assignmentSearchBox	|desc					|
      | invalid_assgn_duedate	|assignmentSearchBox	|dueDate			|
      | invalid_assgn_grade		|assignmentSearchBox	|grade				|
      
      
      
 Scenario Outline: Verify Edit assignment popup window
   Given Admin is on manage assignment page
    When Admin clicks Edit button in data table
    Then Edit popup window appears with heading "<heading title>"
    
    Examples: 
    |heading title      |
    | Assignment Details |
    
    
  Scenario Outline: Verify values in popup window
   Given Admin is on manage assignment page
    When Admin clicks Edit button in data table
    Then Edit popup window appears with same row values in the all fields
  
