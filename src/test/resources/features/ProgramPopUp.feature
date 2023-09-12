 
 
 Feature: Verify Add/Edit Programs Functionality
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
