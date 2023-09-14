Feature: Verify Forget Password and username
Background: Admin in login page after clicking login button in home page


Scenario: Verify forgot username or password link
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should land on forgot username or password page


Scenario: verify broken link
Given Admin is in login page
When Admin clicks forgot username or password link
Then HTTP response >= 400 the link is broken

Scenario: verify input descriptive text for Email
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see Email text in gray color

Scenario: Verify email text in text field
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see Email in text field

Scenario: Verify send link button is present
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see send Link  button

Scenario: Verify asterik near Email text
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see asterik symbol near Email

Scenario: Verify text spelling 
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see correct spellings in all fields 

Scenario: Verify the alignment of the send link button
Given Admin is in login page
When Admin clicks forgot username or password link
Then Admin should see send link button in center of the page

Scenario: Validate email sent for forgot password
Given Admin is in login page
When Admin clicks forgot username or password link
And Admin Enter Valid Email Id 
And Admin click on Send Link
Then Admin should receive link in email for reset username/password


Scenario: Validate email sent for forgot password with invalid email id
Given Admin is in login page
When Admin clicks forgot username or password link
And Admin Enter inValid Email Id 
And Admin click on Send Link
Then Admin should not receive link in email for reset username/password


