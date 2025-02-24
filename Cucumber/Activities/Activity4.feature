@activity4
Feature: Login Test
 

  @Test
  Scenario: Testing Login without Examples
    Given User is on Login page1
    When User enters "admin" and "password"
    Then Read the page title and confirmation message1
    And Close
   