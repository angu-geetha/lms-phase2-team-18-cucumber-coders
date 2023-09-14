Feature: Verify the delete functionality in Programs

  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks program button on the navigation bar 
    And Admin clicks delete button in data table for "Program"
    Then Admin should see dialog box for "Program"
    
    
  Scenario Outline: Validate accept in alert and successful deletion message
    Given Admin is in delete alert for "Program"
    When Admin clicks "yes" button
    Then Redirected to assignment page and selected assignment details are not deleted from the data table for "single"
    And Admin should see "Successful Program Deleted"  alert message
 	

  Scenario Outline: Validate reject in alert
    Given Admin is in delete alert for "Program"
    When Admin clicks "No" button
    Then Redirected to program page and selected program details are deleted from the data table for "single"
    
    Scenario Outline: Validate close in alert
    Given Admin is in delete alert for "Program"
    When Admin clicks Cancel/Close_X Icon on Deletion alert
    Then Redirected to program page and selected program details are deleted from the data table for "single"