Feature: search in google
  the user does a keyword search on Google
  @smokeTest
  Scenario: search in google with a keyword
    Given the user open google
    When the user search for "test"
    Then the search result start with "test" is displayed

