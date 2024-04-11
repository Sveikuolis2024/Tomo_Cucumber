@setUp #tags
Feature: Login page functionality

  Background:
    Given User is on Products page
    When User clicks menu button
    Then Log In button is visible
    When User clicks Log In button
    Then User is on Login page

  Scenario: User successfully login to Products page
    When user enters valid Username
    And user enters valid Password
    And user clicks Login button
    Then user is navigated to Products page

  Scenario: User trying to login with bad Username and Password credentials
    When user enters not valid Username or not valid Password
    And user clicks Login button
    Then user gets error message “Provided credentials do not match any user in this service“

    Scenario: User Trying to login with locked out credentials
    When user enters locked out user credentials
    And user clicks Login button
    Then user gets error message “Sorry, this user has been locked out.“