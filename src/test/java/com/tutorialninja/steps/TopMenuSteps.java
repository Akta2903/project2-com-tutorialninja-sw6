package com.tutorialninja.steps;

import com.tutorialninja.pages.ComponentsPage;
import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopMenuSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {

    }

    @When("^I mouse hover and click on Desktops tab$")
    public void i_mouse_hover_and_click_on_Desktops_tab()  {
       new  HomePage().mouseHoverOnDesktopsLinkAndClick();
    }

    @When("^I select the menu \"([^\"]*)\"$")
    public void i_select_the_menu(String menu)  {
     new HomePage().selectMenu(menu);
    }

    @When("^I verify the text \"([^\"]*)\"$")
    public void i_verify_the_text(String expected)  {
        String actualText = new DesktopPage().getDesktopsText();
        Assert.assertEquals(expected,actualText);
    }

    @Then("^I should navigate to Desktops page successfully$")
    public void iShouldNavigateToDesktopsPageSuccessfully() {
    }

    @When("^I mouse hover and click on Laptops and Notebooks tab$")
    public void iMouseHoverAndClickOnLaptopsAndNotebooksTab() {
        new HomePage().mouseHoverOnLaptopsAndNotebooksLinkAndClick();
    }

    @And("^I verify the text displayed  \"([^\"]*)\"$")
    public void iVerifyTheTextDisplayed(String expected)  {
        Assert.assertEquals(expected,new LaptopsAndNotebooksPage().getLaptopsAndNotebooksText());

    }

    @Then("^I should navigate to Laptops&Notebooks page successfully$")
    public void iShouldNavigateToLaptopsNotebooksPageSuccessfully() {
    }

    @When("^I mouse hover and click on Components$")
    public void iMouseHoverAndClickOnComponents() throws InterruptedException{

        new HomePage().mouseHoverOnComponentLinkAndClick();
    }

    @And("^I verify text displayed \"([^\"]*)\"$")
    public void iVerifyTextDisplayed(String expected)  {
        Assert.assertEquals(expected,new ComponentsPage().getComponentsText());

    }

    @Then("^I should navigate to Components page successfully$")
    public void iShouldNavigateToComponentsPageSuccessfully() {
    }
}
