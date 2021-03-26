# BBlog_BackBase
This repository contains Selenium-TestNG Automation Testing Project of 'BBlog' using Core Java as the scripting language.

All the test cases have been included in the excel file 'BackBase BBlog TestCases.xlsx.
4 (four) among the 16 test cases for CRUD Articles functionality; highlighted and marked with '*' sign in the sheet 'Test Repository' have been automated.

Key Highlights:

I have used Selenium WebDriver with Java and a TestNG test automation framework.
Used the Page Factory Model, design pattern to create an Object Repository for web UI elements.
I have used xpath selectors to locate Web UI Elements.
Used data.properties file to fetch data as 'key-value' pair using Properties class.
Created assertions using TestNG to validate the test cases.
Used TestNG Listeners to keep track of the execution and handle events based on its behaviour.
Printed essential information on the console.
Used extent reports to achieve reporting and real-time analytics in graphical format.
Inserted Screenshots of a Failed Test Cases in Extent Reports.

Automation Framework details:

The test-cases can be executed either on Google Chrome or Mozilla Firefox browsers.
WebDriver-compatible clients, 'geckodriver.exe' and 'chromedriver.exe' have been included in the project.
Page Objects and Project Resources can be found at BBlog\src\main\java\pageObjects and BBlog\src\main\java\projectResources respectively.
All the Tests can be found at BBlog\src\test\java\BackBase\BblogTest.java
Extent reports can be found at BBlog\reports\index.html (copy the link and open in a browser for better visibility & understanding)
Screenshots of Failed test cases can be found at BBlog\reports\
TestNG reports can be found at BBlog\ test-output\ suite\ index.html

How to run:

Import/ download the entire project in the local machine and open in an IDE such as Eclipse or IntelliJ.
Run using TestNG.xml

Java 8 and above version needs to be installed.
Download and Install Maven
System environment variables in the machine for Java_HOME, MAVEN_HOME and build path needs to be set.
Test cases are compatible with Chrome and Firefox browser.
Go to command prompt/ terminal, set java project as current directory.
Type command 'mvn test' and press Enter.


*********NOTE*************
Test Case with name 'TestReadArticleYourFeedGlobalFeedPopularTags' has been purposely failed to showcase the capability of framework to capture and display the screenshots at Bblog\ reports\ location in the framework and also in the extent report(Bblog\ reports\index.html).
