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
    Then Admin should land on dashboard page

  Scenario Outline: Verify landing in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see URL with "<UrlName>"

    Examples: 
      | UrlName                |
      | manageAssignmentHeader |

  Scenario: Capture the response time to navigate to manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Get the response time for navigation from dashboard page to manage assignment page

  Scenario Outline: : Verify manage assignment page Header
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see header with "<UrlName>"

    Examples: 
      | UrlName    |
      | Assignment |

  Scenario Outline: Validate text in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar and get all text from the portal page "<Columnheaders>"
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

  Scenario Outline: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see disabled delete icon below the "<UrlName>"

    Examples: 
      | UrlName                |
      | manageAssignmentHeader |

  Scenario Outline: Verify search bar on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see search bar on the "<UrlName>"

    Examples: 
      | UrlName                |
      | manage assignment page |

  Scenario: Verify add new assignment button  on manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see +Add New assignment button on the manage assignment page

  Scenario Outline: Verify data table on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see data table on the manage assignment page With following column headers "<Columnheaders>"

    Examples: 
      | Columnheaders          |
      | check box symbol       |
      | Assignment name        |
      | Assignment description |
      | Assignment Due Date    |
      | Assignment Grade       |
      | Edit                   |
      | Delete                 |

  Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available
