@ignore
Feature: Browsing history
  Background:
    Given I am on the Amazon homepage for login
    And I go to Amazon login page
    When I enter my email as mcobanlar34@gmail.com
    When I click the continue button
    When I enter my password as sa4rga02bn
    When I click the Sign In button
    Then I should be logged in

  Scenario Outline: Visited product gets added to browsing history
    When I search for <productName> product
    And I click on the first search result
    Then I should be on the product details page
    Then the <productName> product should be listed in my browsing history
    Examples:
    | productName  |
    | pencil       |
    | computer     |
