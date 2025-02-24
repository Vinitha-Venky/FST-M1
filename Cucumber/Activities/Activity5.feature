@activity5
Feature: Login Test
 

  @Test
  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<userNames>" and "<passwords>"
    Then Read the page title and confirmation message
    And Close the Web Browser
    
  Examples:
  	| userNames | passwords |
  	| admin | password |
  	| adminUser | password |
  	
   
   