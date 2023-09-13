Feature: Verify All Navigation
Background: 
    Given Admin is logged into the LMS portal 
    And Admin is in the student details page

Scenario Outline: The user is able to navigate to all options in Navigation bar from Student Page
   
    When Admin clicks student link on the navigation bar and get all text from the portal page "<Columnheaders>"
     Then Admin should see correct spelling for the all the fields

     Examples: 
      | Columnheaders |
      | Student       |
      | Program       |
      | Batch         |
      | Class         |
      | User          |
      | Assignment    |
      | Attendance    |
    





