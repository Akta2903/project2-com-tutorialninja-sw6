package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopsAndNotebooksPage.class.getName());

    //By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText ;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;
    //By productsPrices = By.xpath("//p[@class ='price']");

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    //By productsList = By.xpath("//h4/a");

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    //By sortBy = By.id("input-sort");
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement textCheckout;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomer;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckout;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement comments;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continue1;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = productsPrices;
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Getting Product price ");
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        log.info("Select the filter " + sortBy.toString());
    }

    public void selectProductByName(String product) {
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
        log.info("Select the Product ");
    }

    public void clickOnMacBook()
    {
        clickOnElement(macBook);
    }

    public void clickOnCheckoutButton() {
        log.info("clicking on checkout button.");
        clickOnElement(checkoutButton);
    }

    public String verifyTheTextCheckout() {
        log.info("Verify the text checkout");
        return getTextFromElement(textCheckout);
    }

    public String verifyTheTextNewCustomer() {
        log.info("Verify the text Newcustomer");
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckOutRadioButton() {
        log.info("clicking on guest checkout radiobutton.");
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueTab() {
        log.info("clicking on continue tab.");
        clickOnElement(continueTab);
    }

    public void enterFirstName(String fName) {
        log.info("Enter fName" + fName + "to firstName " + firstName.toString());
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        log.info("Enter lName " + lName + "to lastName  " + lastName.toString());
        sendTextToElement(lastName, lName);
    }

    public void enterEmailId(String emailId) {
        log.info("Enter emailId " + emailId + "to email " + email.toString());
        sendTextToElement(email, emailId);
    }

    public void enterTelephone(String number) {
        log.info("Enter number " + number + "to telephone" + telephone.toString());
        sendTextToElement(telephone, number);
    }

    public void enterAddress(String add) {
        log.info("Enter add " + add + "to address " + address.toString());
        sendTextToElement(address, add);
    }

    public void enterCity(String cityName) {
        log.info("Enter cityName " + cityName + "to city " + city.toString());
        sendTextToElement(city, cityName);
    }

    public void enterPostCode(String postalCode) {
        log.info("Enter postalCode" + postalCode + "to postcode" + postCode.toString());
        sendTextToElement(postCode, postalCode);
    }

    public void selectCountryFromDropDown(String countryName) {
        log.info("select country from dropdown");
        selectByVisibleTextFromDropDown(country, countryName);
    }

    public void selectRegionFromDropDown(String regionName) {
        log.info("select region from dropdown");
        selectByVisibleTextFromDropDown(region, regionName);
    }

    public void clickOnContinueButton() {
        log.info("clicking on continue button.");
        clickOnElement(continueButton);
    }

    public void addCommentsAboutYourOrder() {
        log.info("Add Comments About your order into text area");
        sendTextToElement(comments, "I have added two products");
    }

    public void clickOnTermsAndConditionsCheckBox() {
        log.info("clicking on Terms & Conditions check box.");
        clickOnElement(termsAndCondition);
    }

    public void clickOnContinue() {
        log.info("clicking On Continue button.");
        clickOnElement(continue1);
    }

    public String verifyMessagePaymentMethodRequired() {
        log.info("verify Message Payment Method Required");
        return getTextFromElement(warningMessage);
    }
}
