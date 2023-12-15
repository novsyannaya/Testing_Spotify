# Testing_Spotify
Practical assessment in Automated testing

## Task description
For this task, use the Selenium WebDriver, framework unit test parameterization, Page Object Model

Launch the spotify Url "https://open.spotify.com/" and the use case to automate would be Login functionality.

UC -1 - Test Login form with empty credentials 1.Type any credentials 2.Clear the inputs. 3.Check the error messages: 3.1 Please enter your Spotify username or email address. 3.2 Please enter your password.

UC-2 - Test Login form with incorrect credentials 1.Type any incorrect credentials and click LOG IN button. 2. Check the error message: 2.1 Incorrect username or password.

UC -3 - Test Login form with correct credentials 1.Type correct credentials and click LOG IN button. 2.Check that Name is correct.



## Installation and Launch

The project uses the selenium-chrome-driver dependency version 4.10. 
If you get some errors with libraries when running the tests, please modify the pom.xml file:
`<dependencies>
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.15.0</version>
</dependency>
<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>7.7.0</version>
<scope>test</scope>
</dependency>
</dependencies>`