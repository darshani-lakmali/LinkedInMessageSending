# LinkedInMessageSending
This assignment is to automate LinkedIn message sending.Following Test scenarios are covered from this automation suite. 
1.Title of Login Page 
2.User login with correct credentials 
3.Send a message to a known person 
4.Try sending a message to a person not in connections 
5.logout from LinkedIn

How to install this project: 
* Pull the code from the repository into your local git repository. 
* In the src/test/resources/config.properties file, default browser has been set to 'chrome'. for the cross browser testing, browser property can be changed to the expected browser name. eg: firefox, edge 
* In the src/test/resources/config.properties file, username and password is blank so that you can add your Linkedin login credentials there.
* Install and set up java and maven in your machine. Open command prompt cd until the automation project root directory. Run the command. mvn clean test

How to run the reports: 
Spark extent html report and extent pdf reports are made enable for this project. 
* extent.pdf report will be generated in the test output folder of the project root directory. 
   eg:C:\LinkedinMessageSending\test output\PdfReport\ExtentPdf.pdf 
* index.html report will be generated in the test-output folder of the project root directory. 
   eg:C:\LinkedinMessageSending\test-output\SparkReport\index.html
