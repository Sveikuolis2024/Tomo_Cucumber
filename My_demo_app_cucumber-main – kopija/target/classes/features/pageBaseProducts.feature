#run tests via arrow in TestRunner or mvn test or via arrow in feature file

@setUp #tags
Feature: Products page functionality

  @DoTest
  Scenario: User sorts products by name
    Given User is on "Products" page
    When User clicks "sort button" button
    And User clicks "nameAsc" button
    Then First product title is "Sauce Labs Backpack"

#  User story: User can sort products by multiple criteria
#
#  Acceptance criteria:
#    Given User is on Products Page
#    When clicking sort products button
#    And choose the sorting option (Name asc, Name desc, Price asc, Price desc)
#    Then products are sorted correctly by the chosen criteria
  @DoTest
  Scenario Outline: User sorts products by various criteria
    Given User is on "Products" page
    When User clicks "sort button" button
    And User clicks "<sort by>" button
    Then First product title is "<title>"

    Examples:
      | sort by   | title                       |
      | nameAsc   | Sauce Labs Backpack         |
      | nameDesc  | Test.allTheThings() T-Shirt |
      | priceAsc  | Sauce Labs Onesie           |
      | priceDesc | Sauce Labs Fleece Jacket    |

