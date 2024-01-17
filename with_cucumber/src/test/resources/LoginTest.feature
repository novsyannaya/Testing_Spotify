Feature: Login
 Scenario Outline: Check if login correct
    Given I'm on the home page of Spotify
    And I go to login page
    And I login using my "<email>" and "<password>" for "<type>" of test
    Then I get correct "<result>" for this "<type>"
   Examples:
     | type | email | password | result |
     | empty | login | password | Please enter your Spotify username or email address.; Please enter your password. |
     | incorrect | forEpamTest | password | Incorrect username or password. |
     | correct | alt.r3-9oeklslp@yopmail.com | ForTest123 | forEpamTest |

