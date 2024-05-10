Feature: The application should be running

  @smoke @test
  Scenario: simple login
    Given I am on the home page
    When I clicked "Form Authentication" page
    And I fill the form with valid credentails
    Then I should see "You logged into a secure area!" message

