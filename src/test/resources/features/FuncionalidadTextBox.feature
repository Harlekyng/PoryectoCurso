Feature: Test the TextBox action on the ToolsQA page.

  @Test
  Scenario: Submitting the form
    Given I am on the ToolsQA page
    When I enter a name "Christian" in the text box
    And I enter an email
    And I enter a current address
    And I enter a permanent address
    And I click on the submit button
    Then the form should be submitted successfully