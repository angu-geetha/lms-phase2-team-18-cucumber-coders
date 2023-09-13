Feature: Verify Login Credential
 Background: Admin in login page after clicking login button in home page
  
  Scenario Outline: User  Login with  valid  username and password
    Given User is on Login page
    When User enters valid username "<username>" and password "<password>"
    And User clicks on login button
    Then It should navigate to the home page with a message " results"

    Examples: 
      | username| password |results|
      |sdet     |J@1234  |You are logged in|
      
      
  Scenario Outline: To verify login with InValid username and  Invalid password and gets the result "<result>"
    Given User is on Login page
    When User enters valid username as "<username>" and  Invalid password as "<password>" and gets the result "<result>"
    And User clicks on login button
    Then User verify the message as "<result>"

    Examples: 
      | username | password     |result|
      | asdfger  |  @@@@        |Invalid Username and Password|
      | Blank    | Blank        |Error message please check username/password                |
      | Blank    |dgddhf        |Error message please check username/password|
      | sdgfdhd  |  Blank       |Error message please check username/password|   

Scenario: verify login button action through keyboard
Given Admin is in login page
When Admin enter valid credentials and clicks login button through keyboard
Then Admin should land on dashboard page


Scenario: verify login button action through mouse
Given Admin is in login page
When Admin enter valid credentials  and clicks login button through mouse
Then Admin should land on dashboard page

