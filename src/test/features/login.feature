
Feature: Amazon Login
  @ignore
  Scenario: Successful login
    Given I am on the Amazon homepage for login
    And I go to Amazon login page
    When I enter my email as mcobanlar34@gmail.com
    When I click the continue button
    When I enter my password as sa4rga02bn
    When I click the Sign In button
    Then I should be logged in

  Scenario: Unsuccessful login
    Given I am on the Amazon homepage for login
    And I go to Amazon login page
    When I enter my email as trials@gmail.com
    When I click the continue button
    When I enter my password as invalidpass
    When I click the Sign In button
    Then I shouldn't be logged in

