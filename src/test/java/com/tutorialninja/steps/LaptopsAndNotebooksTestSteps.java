package com.tutorialninja.steps;

import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCartPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTestSteps {
    @When("^I mouse hover on Laptops & Notebooks$")
    public void iMouseHoverOnLaptopsNotebooks() {
        new HomePage().mouseHoverOnLaptopsAndNotebooksLinkAndClick();

    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String menu)  {
        new HomePage().selectMenu(menu);
    }

    @And("^I select the Sort By filter \"([^\"]*)\"$")
    public void iSelectTheSortByFilter(String filter)  {
        new LaptopsAndNotebooksPage().selectSortByOption(filter);

    }

    @Then("^Products should be displayed in High To Low order as per the price$")
    public void productsShouldBeDisplayedInHighToLowOrderAsPerThePrice() {
        List<Double> originalProductsPrice = new LaptopsAndNotebooksPage().getProductsPriceList();
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        ArrayList<Double> afterSortByPrice = new LaptopsAndNotebooksPage().getProductsPriceList();
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }



    @And("^The text displayed on the page is \"([^\"]*)\"$")
    public void theTextDisplayedOnThePageIs(String expected)  {
      Assert.assertEquals(new ProductPage().getProductText(),expected);
    }

    @And("^I click on the button Add To Cart$")
    public void iClickOnTheButtonAddToCart() {
        new ShoppingCartPage().changeCurrency("£Pound Sterling");
        new ProductPage().clickOnAddToCartButton();
    }

    @And("^The text should be displayed on the page  \"([^\"]*)\"$")
    public void theTextShouldBeDisplayedOnThePage(String expected)  {
        String expectedMessage = "Success: You have added MacBook to your shopping cart! X";
        String actualMessage = new ProductPage().getProductAddedSuccessMessage();
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message); }

    @And("^I click on Shopping Cart link in the displayed message$")
    public void iClickOnShoppingCartLinkInTheDisplayedMessage() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();
    }

    @And("^The text visible on the page is \"([^\"]*)\"$")
    public void theTextVisibleOnThePageIs(String expected)  {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartText().contains(expected));

    }

    @And("^The product name displayed \"([^\"]*)\"$")
    public void theProductNameDisplayed(String expected)  {
        Assert.assertEquals(new ShoppingCartPage().getProductName(),expected);

    }

    @And("^I update the quantity \"([^\"]*)\"$")
    public void iUpdateTheQuantity(String qty)  {

        new ShoppingCartPage().changeQuantity(qty);


    }

    @And("^I click on Update button$")
    public void iClickOnUpdateButton() {
        new ShoppingCartPage().clickOnQtyUpdateButton();
    }

    @And("^I verify the text displayed on page is \"([^\"]*)\"$")
    public void iVerifyTheTextDisplayedOnPageIs(String expected)  {
        Assert.assertTrue(new ShoppingCartPage().getSuccessModifiedMessage().contains(expected));
    }

    @And("^I verify the total \"([^\"]*)\"$")
    public void iVerifyTheTotal(String total)  {
        Assert.assertEquals(new ShoppingCartPage().getTotal(),total);

    }

    @And("^I click on Checkout button$")
    public void iClickOnCheckoutButton() {
        new LaptopsAndNotebooksPage().clickOnCheckoutButton();
    }

    @And("^I should see the text is \"([^\"]*)\"$")
    public void iShouldSeeTheTextIs(String expected)  {
      Assert.assertEquals(new LaptopsAndNotebooksPage().verifyTheTextCheckout(),expected);

    }

    @And("^I should be able to see the text is \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheTextIs(String expected)  {
        Assert.assertEquals(new LaptopsAndNotebooksPage().verifyTheTextNewCustomer(), expected);

    }

    @And("^I click on radio button \"([^\"]*)\"$")
    public void iClickOnRadioButton(String arg0)  {
        new LaptopsAndNotebooksPage().clickOnGuestCheckOutRadioButton();
    }



    @And("^I fill all the mandatory fields$")
    public void iFillAllTheMandatoryFields(DataTable dataTable)
    {
        List<List<String>> mandatoryFields = dataTable.asLists(String.class);
        String firstName = mandatoryFields.get(0).get(0);
        String lastname = mandatoryFields.get(0).get(1);
        String email = mandatoryFields.get(0).get(2);
        String telephone = mandatoryFields.get(0).get(3);
        String address = mandatoryFields.get(0).get(4);
        String city = mandatoryFields.get(0).get(5);
        String postcode = mandatoryFields.get(0).get(6);
        String country = mandatoryFields.get(0).get(7);
        String region = mandatoryFields.get(0).get(8);

        new LaptopsAndNotebooksPage().enterFirstName(firstName);
        new LaptopsAndNotebooksPage().enterLastName(lastname);
        new LaptopsAndNotebooksPage().enterEmailId(email);
        new LaptopsAndNotebooksPage().enterTelephone(telephone);
        new LaptopsAndNotebooksPage().enterAddress(address);
        new LaptopsAndNotebooksPage().enterAddress(address);
        new LaptopsAndNotebooksPage().enterCity(city);
        new LaptopsAndNotebooksPage().enterPostCode(postcode);
        new LaptopsAndNotebooksPage().selectCountryFromDropDown(country);
        new LaptopsAndNotebooksPage().selectRegionFromDropDown(region);

    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() throws InterruptedException {
        Thread.sleep(2000);
        new LaptopsAndNotebooksPage().clickOnContinueButton();

    }

    @And("^I add the comments abut your order$")
    public void iAddTheCommentsAbutYourOrder() {
        new LaptopsAndNotebooksPage().addCommentsAboutYourOrder();
    }

    @And("^I check the terms & Conditions checkbox$")
    public void iCheckTheTermsConditionsCheckbox() throws  InterruptedException{
        Thread.sleep(200);
        new LaptopsAndNotebooksPage().clickOnTermsAndConditionsCheckBox();

    }

    @And("^I click on Continue$")
    public void iClickOnContinue() {
        new LaptopsAndNotebooksPage().clickOnContinue();
    }

    @Then("^I verify the message \"([^\"]*)\"$")
    public void iVerifyTheMessage(String expected)
    {
        Assert.assertEquals(new LaptopsAndNotebooksPage().verifyMessagePaymentMethodRequired().substring(0,33),expected);

    }

    @And("^I click on the Continue button$")
    public void iClickOnTheContinueButton() {
        new LaptopsAndNotebooksPage().clickOnContinueTab();
    }



    @And("^I select product name Macbook$")
    public void iSelectProductNameMacbook() {
        new LaptopsAndNotebooksPage().clickOnMacBook();
    }
}
