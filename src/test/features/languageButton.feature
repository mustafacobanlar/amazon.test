Feature: Language functionality on Amazon.com

  Scenario: Verify that the website content is displayed in the correct language when the language is changed
    Given I am on the homepage
    When I click on the language dropdown
    And I select a different language option
    Then the website content should be displayed in the selected language
