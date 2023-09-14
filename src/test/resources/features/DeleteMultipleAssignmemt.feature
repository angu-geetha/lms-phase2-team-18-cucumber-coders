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
    And Admin clicks check box in the data table for "Assignment" for 2 checkbox
    And Admin should click delete icon below the "manageAssignmentHeader"
    Then Admin should see dialog box for "Assignment"

    

  Scenario Outline: Validate accept in alert
    Given Admin is in delete alert for "Assignment"
    When Admin clicks "yes" button
    Then Redirected to Assignment page and selected assignment details are deleted from the data table for "multiple"

    

  Scenario Outline: Validate reject in alert
    Given Admin is in delete alert for "Assignment"
    When Admin clicks "No" button
    Then Redirected to Assignment page and selected assignment details are deleted from the data table for "multiple"
    

