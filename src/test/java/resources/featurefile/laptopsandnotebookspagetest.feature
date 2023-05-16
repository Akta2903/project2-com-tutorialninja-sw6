Feature: Laptops&NoteBooks Test

  As a user I want to verify the Laptops&Notebooks page functionality

  @sanity @regression
    Scenario: Verify product price display in High to Low order
    Given I am on homepage
    When I mouse hover on Laptops & Notebooks
    And I click on "Show AllLaptops & Notebooks"
    And I select the Sort By filter "Price (High > Low)"
    Then Products should be displayed in High To Low order as per the price
