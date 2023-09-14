Feature: Verify the Delete All Users functionality

  Background: Admin is Logged In LMS portal
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    And  Admin clicks user button on the navigation bar 
    And Admin clicks check box in the data table for "User" for 2 checkbox
    And Admin should click delete icon below the "manageUserHeader"
    Then Admin should see dialog box for "User"

    

  Scenario Outline: Validate accept in alert
    Given Admin is in delete alert for "User"
    When Admin clicks "yes" button
    Then Redirected to user page and selected user details are deleted from the data table for "multiple"

    

  Scenario Outline: Validate reject in alert
    Given Admin is in delete alert for "Program"
    When Admin clicks "No" button
    Then Redirected to user page and selected user details are not deleted from the data table for "multiple"
    

