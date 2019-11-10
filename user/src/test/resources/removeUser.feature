Feature: Try to remove user
    Remove user from databas.

  Scenario Outline: Try to remove user from database.
    Given list of users in database
    When try to remove <user_name>
    Then the answer should be: NullPointerException

    Examples:
      |user_name  |
      |"Robert"   |
      |"Kamil"    |