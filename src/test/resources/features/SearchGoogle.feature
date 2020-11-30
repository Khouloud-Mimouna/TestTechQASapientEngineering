Feature: search in google
  the user does a keyword search on Google
  @smokeTest
  Scenario Outline: search in google with a keyword
    Given the user open google
    When the user search for "<keyword>"
    Then the search result start with "<keyword>" is displayed
  Examples:
      | keyword|
      | test   |
      | java   |
      | gherkin|