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

  Scenario Outline: Verify Assignment details popup window 
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see a popup  with  heading "<heading>"

    Examples: 
      | heading       				|
      | Assignment details		|
      
  Scenario Outline: Verify input fields in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see input fields Text  "<heading>"

    Examples: 
      | heading       				|
      | Assignment		|

Scenario Outline: Verify text box present in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then "<noOfTextBox>" textbox should be  present in "<heading>" details popup window
  
  Examples: 
      | noOfTextBox | heading       				|
      | 8		|Assignment |

Scenario Outline: Verify drop down in Batch Number  in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see dropdown option for Batch Number
  
Scenario Outline: Verify drop down in Program name  in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see dropdown option for Program name
  
  
Scenario Outline: Verify calendar icon in Assignment due date  in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see  calendar icon for assignment due date

Scenario Outline: Verify save button is present in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see  save button in the "<heading>" popup window
  
  Examples: 
      | heading       				|
      | Assignment		|

Scenario Outline: Verify close button in  Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see  close button on the "<heading>" popup window
   Examples: 
      | heading       				|
      | Assignment		|
      
      
Scenario Outline: Verify cancel button is present in Assignment details popup window
  Given Admin is on manage assignment page
  When Admin click +Add new assignment button
  Then Admin should see  cancel button in the "<heading>" popup window
  Examples: 
      | heading       				|
      | Assignment		|
      
    














