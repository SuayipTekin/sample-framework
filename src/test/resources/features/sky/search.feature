Feature: As a user I should be able to search on google

  @sky @regression @smoke @DI-3465
  Scenario: Verifying that user able to search on google
    Given User should be able to go to google search page
    When User searches "book"
#    Then User able to see "" on the page

