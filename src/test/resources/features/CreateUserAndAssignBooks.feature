Feature: Create user and assign books to it

  Scenario Outline: Create user and assign books
    When I create an user with the following details:
      | userName   | password   |
      | <userName> | <password> |
    And The user is created
    And A token is generated for user <userName> with password <password>
    And Authorization is done for user <userName> with password <password>
    And I add the following books for user <userName>:
      | <isbn1> |
      | <isbn2> |
    Then I see the books are associated with the user:
      | <isbn1> |
      | <isbn2> |
    Examples:
      | userName | password    | isbn1         | isbn2         |
      | LauraS12 | La12123456! | 9781449331818 | 9781449337711 |