Feature: Create user and assign books to it

  Scenario Outline: Create user and assign books
    When I create an user with the following details
      | userName   | password   |
      | <userName> | <password> |
    And the user is created
    And I add the following books for user <userName>:
      | <isbn1> |
      | <isbn2> |
    Then I see the books are associated with the user:
      | <isbn1> |
      | <isbn2> |
    Examples:
      | userName | password    | isbn1 | isbn2 |
      | LauraS7  | La12123456! | 123   | 1234  |