Feature: Home Page Verification

  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should land on the home page

  Scenario: Verify admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then HTTP response >= 400 the link is broken

  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should see correct spellings in all fields

  Scenario: Verify the logo of the LMS
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should see correct logo of the LMS

  Scenario: Verify the logo properly aligned
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should see logo is properly aligned

  Scenario: Verify login button is present
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should see login button

  Scenario: Verify login button is clickable
    Given Admin launch the browser
    When Admin gives the Valid LMS portal URL
    Then Admin should able to click the Login button
