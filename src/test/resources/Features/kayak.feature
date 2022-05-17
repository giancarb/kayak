Feature: To test kayak
  @addition
  Scenario: Check the addition functionality
    Given user is on kayak page
    When user accept privacy
    When select data
    Then user is on result page
    And user set Departure and Arrival Date
    And user set price
