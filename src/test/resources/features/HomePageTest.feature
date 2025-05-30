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

  @RightClick @Smoke
  Scenario: Context click Test
    Given User is in HerokuApp Home Page
    Then User Navigates to Context click page and Verifies Context Click

  @DragAndDrop @Smoke
  Scenario: Drag and Drop Test
    Given User is in HerokuApp Home Page
    Then User Navigates to Drag and Drop page and Verifies Drag and drop