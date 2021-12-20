Feature: As a user I should be able to search on google

  @test
  Scenario: Verifying that user able to search on google
    Given User should be able to go to google search page
    When User searches "Gogo"
    Then User able to see "Gogo Inflight Internet Company | Home" on the page

