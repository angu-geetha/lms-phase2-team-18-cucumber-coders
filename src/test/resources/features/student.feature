Feature: Student Page Verification
Background: Admin is login to LMS portal

Scenario: Validate the title of the page 
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see the Student details Page Title

Scenario: Validate response time from dashboard page to student page
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Maximum navigation time in milliseconds, defaults to 30 seconds

Scenario: Check broken link                     
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should not see >=404 Http code
And Admin Should redirected to Student Detail Page
#Then HTTP response >= 400 then the link is broken    

Scenario: Verify LMS title 
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see LMS-Learning management system  as title

Scenario: Verify the alignment of the Student detail title
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Student Detail title should be in centre of the page

Scenario: Validate drop down is present in the page
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Two dropdowns should be present in the page

Scenario: Validate search bar in select student name drop down
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see search box inside Student name the drop down 

Scenario: Validate search bar in select batch id drop down
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see search box inside  batch id drop down 

Scenario: Validate text spelling student name
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see correct spelling select student name

Scenario: Validate text spelling select batch id
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see correct spelling select  batch id text


Scenario: Validate only numbers inside select batch id
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see only numbers inside batch id drop down


Scenario: Validate gray color in student name drop down
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see select student name in gray color


Scenario: Validate gray color in batch id drop down
Given Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see select batch ID in gray color

Scenario: Validate first drop down label is select student name
Given  Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see select student name in first

 
Scenario: Validate second drop down label is select batch id
Given  Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should see select batch id in second

 
Scenario: Validate scroll down inside student name dropdown
Given  Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should be able to scroll down to select the name
 
Scenario: Validate scroll down inside batch id dropdown
Given  Admin is on dashboard page after Login
When Admin clicks Student on the navigation bar
Then Admin should able to scroll down to select the batch id
 
Scenario: Validate select student name is fading
Given Admin is on student details page
When Admin select student name from the drop down 
Then Admin shouldn not see select student name text 

 
Scenario: Validate select batch id  is fading
Given  Admin is on student details page
When Admin select batch id from the drop down 
Then Admin shouldn nott see select batch id text 
 
 Scenario: Validate select student name using search box
Given  Admin is on student details page
When Admin clicks select student name and  enters x alphabet in the search box 
Then Admin should see student name start with x is listed below
 
 Scenario: Validate select batch id using search box
Given  Admin is on student details page
When Admin  clicks select batch id and enter x number in the search box 
Then Admin should see batch id start with x is listed below
 
 Scenario: Validate selecting only  student name  will not display any details
Given  Admin is on student details page
When Admin selects only student name
Then Student details shouldn not be displayed
 
 Scenario: Validate selecting only batch id  will not display any details
Given  Admin is on student details page
When Admin selects only  batch id
Then Student details shouldn not be displayed
 
Scenario: Validate selecting student name and batch id
Given Admin is on student details page
When Admin selects  student name and batch id
Then Particular student informations should be display
 
Scenario: Validate Program link on navigation bar
Given Admin is on student details page
When Admin clicks on program link on student page
Then Admin is redirected to Program page
 
 Scenario:  Validate Batch link on navigation bar
Given Admin is on student details page
When Admin clicks on Batch link on student page
Then Admin is redirected to Batch page

Scenario: Validate Class link on navigation bar
Given Admin is on student details page
When Admin clicks on Class link on student page
Then Admin is redirected to Class page

Scenario:  Validate User link on navigation bar
Given Admin is on student details page
When Admin clicks on User link on student page
Then Admin is redirected to Student page

Scenario:  Validate Assignment link on navigation bar
Given Admin is on student details page
When Admin clicks on Assignment link on student page
Then Admin is redirected to Assignment page

Scenario:  Validate Attendance link on navigation bar
Given Admin is on student details page
When Admin clicks on Attendance link on student page
Then Admin is redirected to Attendance page

Scenario: Validate Logout link on navigation bar
Given Admin is on student details page
When Admin clicks on Logout link on student page
Then Admin is redirected to Logout page
#create seprate feature file for navigation bar only





















