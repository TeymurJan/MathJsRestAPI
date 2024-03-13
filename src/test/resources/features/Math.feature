Feature: Math expression calculations

  Scenario: Evaluate the math calculation results with post request
    Given I have the following expressions
      | 1.2 * (2 + 4.5)  |
      | 9 / 2            |
      | 2+3*sqrt(4)      |
      | 9^2-4^2          |
      | sqrt(25)-sqrt(9) |
      | 9/3+1            |
    When I execute math request with body
    Then I should see this results
      | 7.8 |
      | 4.5 |
      | 8   |
      | 65  |
      | 2   |
      | 4   |

  Scenario: Evaluate the math calculation results with get request
    Given I have the following query parameters
      | 1.2 * (2 + 4.5)  |
      | 9 / 2            |
      | 2+3*sqrt(4)      |
      | 9^2-4^2          |
      | sqrt(25)-sqrt(9) |
      | 9/3+1            |
    When I execute math request with query parameters
    Then I should see this results
      | 7.8 |
      | 4.5 |
      | 8   |
      | 65  |
      | 2   |
      | 4   |