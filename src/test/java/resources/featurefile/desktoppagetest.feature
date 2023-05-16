Feature: Desktops Test

  As a user I want to verify Desktops page functionality

  @sanity
  Scenario: Verify products arranged in Alphabetical order
    Given I am on homepage
    When I mouse hover and click on the Desktops tab
    And  I click on the option "Show AllDesktops"
    And I select Sort By filter "Name (Z - A)"
    Then Products should be arranged in Descending order

    @smoke
    Scenario: Verify product added to shopping cart successfully
      Given I am on homepage
      When I mouse hover and click on Desktops tab
      And I click on the option "Show AllDesktops"
      And I select Sort By filter "Name (A - Z)"
      And I select product "HP LP3065"
      And I verify text "HP LP3065"
      And select delivery date "30", "November", "2023"
      And I enter quantity "1"
      And I change the Currency to "£Pound Sterling"
      And I click on Add To Cart button
      And Message displyed on the page "Success: You have added HP LP3065 to your shopping cart!"
      And I click on Shopping Cart button
      Then verify shopping cart text "Shopping Cart"
      And Verify the product name "HP LP3065"
#      And verify the date "2023-11-30"
      And Verify the Model "Product 21"
      And verify the total "£74.73"


