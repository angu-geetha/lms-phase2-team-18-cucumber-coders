Feature: Verify User - Add/Edit functionality

  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And Admin clicks user button on the navigation bar
    And Admin click +Add new user button
    Then Admin should see a popup  with  heading "User details"

    
  Scenario Outline: Validate admin able to fill in all the fields with valid values and click submit
    Given Admin is in  user details popup window
    When Admin enters data for all fields with valid values
    Then Admin should see new user details is added in the data table

Scenario Outline: Validate admin able to fill in all the fields except optional with valid values and click submit
    Given Admin is in  user details popup window
    When Admin enters data for all fields except optional with valid values
    Then Admin should see new user details is added in the data table
