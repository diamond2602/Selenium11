Feature: Testing google functionalities

  Scenario: Happy path Google search functionality
    Given I navigate to google.com
    When I search for Techtorial
    Then I get more than 1000 links on the google page

