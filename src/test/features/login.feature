Feature: Amazon Login
  As a user
  I want to log in to my Amazon account
  So that I can access my account features

  Scenario: Successful login
    Given I am on the Amazon homepage
    Given I go to Amazon login page
    When I enter my email as "mcobanlar34@gmail.com"
    And I enter my password as "sa4rga02bn"
    And I click the Sign In button
    Then I should be logged in

