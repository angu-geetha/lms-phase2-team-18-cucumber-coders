Feature: Verify the delete functionality in Programs

  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks program button on the navigation bar 
    And Admin clicks delete button in data table for "Program"
    Then Admin should see dialog box for "Program"
    
    
  Scenario Outline: Validate accept in alert
    Given Admin is in delete alert for "Program"
    When Admin clicks "yes" button
    Then Redirected to program page and selected program details are deleted from the data table

    

  Scenario Outline: Validate reject in alert
    Given Admin is in delete alert
    When Admin clicks "No" button
    Then Redirected to program page and selected program details are not deleted from the data table