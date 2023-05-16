Feature: TopMenuLoginTest

  As a user I want to verify Top Menu
  
  @smoke @regression
   Scenario: I should navigate to desktops page successfully
    Given I am on homepage
    When I mouse hover and click on Desktops tab
    And I select the menu "Show AllDesktops"
    And I verify the text "Desktops"
    Then I should navigate to Desktops page successfully

  @sanity @regression
    Scenario: I should navigate to Laptops And Notebooks page successfully
      Given I am on homepage
      When I mouse hover and click on Laptops and Notebooks tab
      And I select the menu "Show AllLapTops & Notebooks"
      And I verify the text displayed  "Laptops & Notebooks"
      Then I should navigate to Laptops&Notebooks page successfully
      
  @regression 
      Scenario: I should navigate to Components page successfully 
        Given I am on homepage
        When  I mouse hover and click on Components 
        And   I select the menu "Show AllComponents"
        And   I verify text displayed "Components"
        Then  I should navigate to Components page successfully