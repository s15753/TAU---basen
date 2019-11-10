Feature: Try to get user name
    Select user from database

  Scenario Outline: Try to select user from database.
    Given take_list of users in database
    When try to select <user_name>
    Then the answer would be: <result>

    Examples:
      |user_name  |result    |
      |"Robert"   |"Robert"  |
      |"Kamil"    |"Kamil"   |
