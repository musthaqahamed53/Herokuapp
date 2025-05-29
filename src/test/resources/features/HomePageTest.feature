Feature: Heroku App HomePage Tests

  Scenario Outline: HerokuApp BasicAuth Test
    Given User is in HerokuApp Home Page
    When User Goes to BasicAuth Page
    Then User gives credential <username> and <password>
    Examples:
      | username | password |
      | admin    | admin1    |