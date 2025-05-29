Feature: ZBroken Image
  @Images @Smoke
  Scenario: Broken Image test scenario
    Given User is in HerokuApp Home Page
    And User goes to Broken Images Page
    Then User Validates the Images
