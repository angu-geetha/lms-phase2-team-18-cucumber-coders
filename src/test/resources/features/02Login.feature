Feature: Login page verification
Background: Admin in login page after clicking login button in home page

Scenario: Verify the login page
Given Admin is in home page
When Admin clicks Login button
Then Admin should land on the login page

Scenario: Verify for broken link
Given Admin is in home page
When Admin clicks Login button
Then HTTP response >= 400 the link is broken
And Admin Should redirected to login Page

Scenario: Verify the Title of the login page 
Given Admin is in home page
When Admin clicks Login button
Then Admin should see "Please login to LMS application" in the title

Scenario: Verify the text spelling in login page 
Given Admin is in home page
When Admin clicks Login button
Then Admin should see correct spellings in all fields

Scenario: Verify text field is present
Given Admin is in home page
When Admin clicks Login button
Then Admin should see two text field

Scenario: Verify text on the first text field
Given Admin is in home page
When Admin clicks Login button
Then Admin should "user" in the first text field

Scenario: Verify asterik next to user text
Given Admin is in home page
When Admin clicks Login button
Then Admin should see "*" symbol next to User text

Scenario: Verify text on the second text field
Given Admin is in home page
When Admin clicks Login button
Then Admin should see "password" in the second text field

Scenario: Verify asterik next to password text
Given Admin is in home page
When Admin clicks Login button
Then Admin should see "*" symbol next to password text

Scenario: Verify the alignment input field for the login
Given Admin is in home page
When Admin clicks Login button
Then Admin should see input field on the centre of the page

Scenario: verify Login is present
Given Admin is in home page
When Admin clicks Login button
Then Admin should see login button

Scenario: Verify the alignment of the login button
Given Admin is in home page
When Admin clicks Login button
Then Admin should see login button on the centre of the page


Scenario: Verify forgot username or password link
Given Admin is in home page
When Admin clicks Login button
Then Admin should see forgot username or password link


Scenario: Verify for the Reset password link
Given Admin is in home page
When Admin clicks Login button
Then Admin should see reset password link


Scenario: Verify input descriptive test in user field
Given Admin is in home page
When Admin clicks Login button
Then Admin should see user in gray color


Scenario: Verify input descriptive test in password field
Given Admin is in home page
When Admin clicks Login button
Then Admin should see password in gray color











