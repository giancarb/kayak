#Author:Aparna Tripathy
#Date:02/16/2022
#Description:Testing of selenium simplified calculator

Feature: To test the simplified calculator

  @addition
  Scenario Outline: Check the addition functionality
    Given browser is open
    And user is on simplified calculator page
    When user enters a number "<value1>" in the first edit box
    And  user enters a number "<value2>" in the second edit box
    And user chose the "plus" operator
    And user hits on Calculate
    Then Validating the sum of "<value1>" and "<value2>" should appear in the Answer

    Examples:
      | value1 | value2 |
      | 2.5    | }      |
      | -5     | -5     |
      | 2.5    | 5.5    |
      | @      | }      |
      | abc    | gtf    |
      |        |        |

  @multiplication
  Scenario Outline: Check the multiplication functionality
    Given browser is open
    And user is on simplified calculator page
    When user enters a number "<value1>" in the first edit box
    And  user enters a number "<value2>" in the second edit box
    And user chose the "times" operator
    And user hits on Calculate
    Then Validating the multiplication of "<value1>" and "<value2>" should appear in the Answer

    Examples:
      | value1 | value2 |
      | 5      | 5      |
      | -5     | -5     |
      | 2.5    | -5.5   |
      | @      | }      |
      | abc    | gtf    |
      | 0      | -2     |
      |        |        |

  @subtraction
  Scenario Outline: Check the subtraction functionality
    Given browser is open
    And user is on simplified calculator page
    When user enters a number "<value1>" in the first edit box
    And  user enters a number "<value2>" in the second edit box
    And user chose the "minus" operator
    And user hits on Calculate
    Then Validating the subtraction of "<value1>" and "<value2>" should appear in the Answer

    Examples:
      | value1 | value2 |
      | 5      | 5      |
      | -5     | -5     |
      | 0      | -1     |
      | -2.5   | 5.5    |
      | @      | }      |
      | abc    | gtf    |
      |        |        |

  @division
  Scenario Outline: Check the division functionality
    Given browser is open
    And user is on simplified calculator page
    When user enters a number "<value1>" in the first edit box
    And  user enters a number "<value2>" in the second edit box
    And user chose the "divide" operator
    And user hits on Calculate
    Then Validating the division of "<value1>" and "<value2>" should appear in the Answer

    Examples:
      | value1 | value2 |
      | 5      | 5      |
      | -5     | -5     |
      | 5      | -5     |
      | 2.5    | -5.5   |
      | @      | }      |
      | abc    | gtf    |
      | 5      | 0      |
      | 0      | -2     |
      |        |        |
			
			
			
			