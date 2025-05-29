Feature: Heroku App HomePage Tests

  @AuthPositive @Smoke
  Scenario Outline: HerokuApp BasicAuth Test
    Given User is in HerokuApp Home Page
    When User Goes to BasicAuth Page
    Then User gives credential <username> and <password>
    Examples:
      | username | password |
      | admin    | admin    |

  @AuthNegative @Smoke
  Scenario Outline: HerokuApp BasicAuth Test
    Given User is in HerokuApp Home Page
    When User Goes to BasicAuth Page
    Then User gives wrong credential <username> and <password>
    Examples:
      | username | password |
      | sheik    | sheik    |

  @Links  @Smoke
  Scenario: HerokuApp Links Test
    Given User is in HerokuApp Home Page
    Then User Validates the links present in the page