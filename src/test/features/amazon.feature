Feature: Search for a product on Amazon

  Scenario: Search for a book
    Given I am on the Amazon homepage
    When I search for "The Great Gatsby"
    Then I should see "The Great Gatsby" in the search results
