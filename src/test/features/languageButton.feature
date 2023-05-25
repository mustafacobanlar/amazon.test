Feature: Language functionality on Amazon.com
  @ignore
  Scenario: Verify that the website content is displayed in the correct language when the language is changed
    Given I am on the Amazon homepage for language button
    When I click on the language dropdown
    And I select a different language option
    Then the website content should be displayed in the selected language
