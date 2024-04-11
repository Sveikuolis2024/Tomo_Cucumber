@setUp #tags
Feature: Login page functionality

  @DoTest
  Scenario: User is successful redirected to Login page
    Given User is on Products page
    When User clicks menu button
    Then Log In button is visible
    When User clicks Log In button
    Then User is on Login page
