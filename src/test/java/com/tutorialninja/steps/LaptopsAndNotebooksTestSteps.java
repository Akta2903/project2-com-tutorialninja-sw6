package com.tutorialninja.steps;

import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
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
}
