@setUp #tags
Feature: Checkout page functionality

  Background:
    Given User is on Products page
    When User clicks menu button
    And User clicks Log In button
    Then User is on Login page
    When user enters valid Username
    And user enters valid Password
    And user clicks Login button
    Then user is navigated to Products page

  Scenario: Enter a shipping address
    Given User is on the checkout page
    When User fills in shipping address fields
    And clicks 'To Payment' button
    Then User is navigated to the payment method window

