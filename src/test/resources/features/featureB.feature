Feature: The application should be running


  @regression @test
Scenario: navigate page
Given I am on the home page
When I clicked "A/B Testing" page
Then I should see page title as "No A/B Test"
