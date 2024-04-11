@setUp #tags
Feature: Checkout page and payment functionality

  Background:
    Given user is on the checkout page after successfully login

  Scenario: Enter a payment method
    Given user is on the payment method window
    When user fills all payment method fields
    And clicks the 'Review Order' button
    Then user is navigated to the review order page