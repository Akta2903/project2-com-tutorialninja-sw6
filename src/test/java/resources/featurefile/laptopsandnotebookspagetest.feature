Feature: Laptops&NoteBooks Test

  As a user I want to verify the Laptops&Notebooks page functionality

  @sanity @regression
    Scenario: Verify product price display in High to Low order
    Given I am on homepage
    When I mouse hover on Laptops & Notebooks
    And I click on "Show AllLaptops & Notebooks"
    And I select the Sort By filter "Price (High > Low)"
    Then Products should be displayed in High To Low order as per the price

    @smoke @regression
      Scenario: Verify that user place order successfully
      Given I am on homepage
      When  I mouse hover on Laptops & Notebooks
      And  I click on "Show AllLaptops & Notebooks"
      And I select product name Macbook
      And The text displayed on the page is "MacBook"
      And I click on the button Add To Cart
#      And The text should be displayed on the page  "Success: You have added MacBook to your shopping cart!"
      And I click on Shopping Cart link in the displayed message
      And The text visible on the page is "Shopping Cart"
      And The product name displayed "MacBook"
      And I update the quantity "2"
      And I click on Update button
      And I verify the text displayed on page is "Success: You have modified your shopping cart!"
      And I verify the total "£737.45"
      And I click on Checkout button
      And I should see the text is "Checkout"
      And I should be able to see the text is "New Customer"
      And I click on radio button "Guest Checkout"
      And I click on the Continue button
      And I fill all the mandatory fields
           |John|Lewis|John2903@gmail.com|02365859834|54 Clifton Gardens|Kingsbury|NW91LD|United Kingdom|London|
      And I click on continue button
      And I add the comments abut your order
      And I check the terms & Conditions checkbox
      And I click on Continue
      Then I verify the message "Warning: Payment method required!"


