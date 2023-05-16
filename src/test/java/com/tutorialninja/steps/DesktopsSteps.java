package com.tutorialninja.steps;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class DesktopsSteps {



    @And("^I select Sort By filter \"([^\"]*)\"$")
    public void iSelectSortByFilter(String filter) throws InterruptedException {
        new DesktopPage().selectSortByOption(filter);

    }

    @Then("^Products should be arranged in Descending order$")
    public void productsShouldBeArrangedInDescendingOrder() {
        ArrayList<String> originalProductsName = new DesktopPage().getProductsNameList();
        Collections.reverse(originalProductsName);
        ArrayList<String> afterSortByZToAProductsName = new DesktopPage().getProductsNameList();
        Assert.assertEquals(originalProductsName,afterSortByZToAProductsName);

    }

    @When("^I mouse hover and click on the Desktops tab$")
    public void iMouseHoverAndClickOnTheDesktopsTab() {
        new HomePage().mouseHoverOnDesktopsLinkAndClick();
    }

    @And("^I click on the option \"([^\"]*)\"$")
    public void iClickOnTheOption(String menu)  {
        new HomePage().selectMenu(menu);
    }

    @And("^I select product \"([^\"]*)\"$")
    public void iSelectProduct(String name)  {
        new DesktopPage().selectProductByName(name);

    }

    @And("^I verify text \"([^\"]*)\"$")
    public void iVerifyText(String expected)  {
      Assert.assertEquals( expected,new ProductPage().getProductText());
    }

    @And("^select delivery date \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void selectDeliveryDate(String day, String month, String year)  {
        new ProductPage().selectDeliveryDate(day, month, year);

    }

    @And("^I enter quantity \"([^\"]*)\"$")
    public void iEnterQuantity(String qty)  {
        new ProductPage().enterQuantity(qty);

    }

    @And("^I click on Add To Cart button$")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @And("^Message displyed on the page \"([^\"]*)\"$")
    public void messageDisplyedOnThePage(String expectedMessage)  {
        Assert.assertTrue(new ProductPage().getProductAddedSuccessMessage().contains(expectedMessage));

    }

    @And("^I click on Shopping Cart button$")
    public void iClickOnShoppingCartButton() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();
    }

    @Then("^verify shopping cart text \"([^\"]*)\"$")
    public void verifyShoppingCartText(String expectedText)  {
        Assert.assertEquals(expectedText,new ShoppingCartPage().getShoppingCartText().substring(0,13));
    }

    @And("^Verify the product name \"([^\"]*)\"$")
    public void verifyTheProductName(String pName)  {
        Assert.assertEquals(pName,new ShoppingCartPage().getProductName());
    }

    @And("^verify the date \"([^\"]*)\"$")
    public void verifyTheDate(String dDate) {
       Assert.assertTrue(new ShoppingCartPage().getDeliveryDate().contains(dDate));
    }

    @And("^Verify the Model \"([^\"]*)\"$")
    public void verifyTheModel(String model)  {
        Assert.assertEquals(model,new ShoppingCartPage().getModel());

    }

    @And("^verify the total \"([^\"]*)\"$")
    public void verifyTheTotal(String total)  {
        Assert.assertEquals(total,new ShoppingCartPage().getTotal());
    }

    @And("^I change the Currency to \"([^\"]*)\"$")
    public void iChangeTheCurrencyTo(String text)  {
        new ShoppingCartPage().changeCurrency(text);

    }
}
