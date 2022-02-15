Feature: LinkedIn Home page feature

Background:
Given authorized user has already logged in to application
 
Scenario: send a message to a known person
When user searches Profectus Kamaljeet "https://www.linkedin.com/in/kamaljeet-singh-0b375215/"
And user gets the profile name on message window
And user enters hello message from given personName
And user gets sent message content
Then message content should be "Hello Kamaljeet"

Scenario: Try sending a message to a person not in connections
When user searches Profectus Kamaljeet "https://www.linkedin.com/in/kamaljeet-singh-0b375215/"
Then user sees the Connect button only

Scenario: logout from LinkedIn
When user clicks on Sign Out button
Then user gets return url "https://www.linkedin.com/feed/"


