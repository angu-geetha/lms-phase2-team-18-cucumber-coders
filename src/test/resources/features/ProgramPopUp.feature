 
 
 Feature: Verify Add/Edit Programs window fields
  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks program button on the navigation bar  
    Then Admin should land on manage program page
    
    
  Scenario Outline: Verify Program details popup window 
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then Admin should see a popup  with  heading "<heading>"

    Examples: 
      | heading       		|
      | Program details		|
      
 
  Scenario Outline: Verify input fields in Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then Admin should see input fields Text  "<heading>"

    Examples: 
      | heading   |
      | Program		|

  
  Scenario Outline: Verify text box present in Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then "<noOfTextBox>" textbox should be  present in "<heading>" details popup window
  
  Examples: 
      | noOfTextBox | heading  |
      |2						|Program	|
      
  
  Scenario Outline: Verify radio buttons present in Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then "<noOfRadioButtons>" radio buttons should be  present in "<heading>" details popup window
  
  Examples: 
      | noOfRadioButtons | heading  |
      |2						|Program	|
      
      
   Scenario Outline: Verify save button is present in Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then Admin should see  save button in the "<heading>" popup window
  
  Examples: 
      | heading       				|
      | Program		|

Scenario Outline: Verify close button in  Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then Admin should see  close button on the "<heading>" popup window
   Examples: 
      | heading       				|
      | Program		|
      
      
Scenario Outline: Verify cancel button is present in Program details popup window
  Given Admin is on manage program page
  When Admin click +Add new program button
  Then Admin should see  cancel button in the "<heading>" popup window
  Examples: 
      | heading       				|
      | Program		|
      
		 