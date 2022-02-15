Feature: Linkedin Login Feature

Scenario: Title of Login Page
Given user is on Login Page
When user get the title of the page
Then page title should be "LinkedIn Login, Sign in | LinkedIn"

Scenario: User login with correct credentials
Given user is on Login Page
When user enters correct username and password
And user clicks on login button
Then user get a left pane text of the home page
And left pane text should be "Who viewed your profile"