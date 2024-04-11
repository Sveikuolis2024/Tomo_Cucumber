@setUp #tags
Feature: logout functionality

  Background:
    Given User is on Products page
    When User clicks menu button
    Then Log In button is visible
    When User clicks Log In button
    Then User is on Login page
    When user enters valid Username
    And user enters valid Password
    And user clicks Login button
    Then user is navigated to Products page

  Scenario: User successfully logout
    When User clicks menu button
    Then menu option “Log Out“ is visible
    When user clicks “Log Out“
    Then popup with a message “Are you sure you want to logout?“ appears
    When user clicks in “Log out“ screen "Log Out" button
    Then popup with a message “You are successfully logged out “
    When user clicks “OK“
    Then Message popup closes
    And User is on Login page

  Scenario: User trying to logout but clicks "cancel" button
    When User clicks menu button
    Then menu option “Log Out“ is visible
    When user clicks “Log Out“
    Then popup with a message “Are you sure you want to logout?“ appears
    When user clicks “Cancel“
    Then popup closes
    And user is still logged in