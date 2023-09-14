Feature: Verify Add/Edit Users window fields
  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks user button on the navigation bar  
    Then Admin should land on manage user page
    
    
  Scenario Outline: Verify Program details popup window 
  Given Admin is on manage user page
  When Admin click +Add new user button
  Then Admin should see a popup  with  heading "<heading>"

    Examples: 
      | heading       		|
      | user details		|
      
 
  Scenario Outline: Verify input fields in User details popup window
  Given Admin is on manage user page
  When Admin click +Add new user button
  Then Admin should see input fields Text  "<heading>"

    Examples: 
      | heading   |
      | User		|