Feature: Visited product gets added to browsing history

  Scenario: Add product to browsing history
    Given I am on the Amazon homepage
    When I search for pencil product
    And I click on the first search result
    Then I should be on the product details page
    When I go back to the homepage
    Then the product should be listed in my browsing history
