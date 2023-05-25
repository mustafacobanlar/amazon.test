Feature: Amazon Login

  Scenario: Successful login
    Given I am on the Amazon homepage for login
    And I go to Amazon login page
    When I enter my email as "mcobanlar34@gmail.com"
    And I enter my password as "sa4rga02bn"
    And I click the Sign In button
    Then I should be logged in

