package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(AccountRegisterPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    //
    By subscribeRadios = By.xpath("//fieldset[3]//input");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getRegisterAccountText() {
        log.info("Getting register Text ");
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
       sendTextToElement(firstNameField, fName);
       log.info("Enter First name " + firstNameField);
    }

    public void enterLastName(String lName) {
       sendTextToElement(LastNameField, lName);
       log.info("Enter Last name " + lName);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        log.info("Enter email " + email);
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
        log.info("Enter Telephone " + telephone);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter password " + password);
    }

    public void enterConfirmPassword(String cPassword) {
       sendTextToElement(passwordConfirmField, cPassword);
       log.info("Enter Confirmpassword ");
    }

    public void selectSubscription(String option) {
         List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
        log.info("Select the radio button ");
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        log.info("Click on privacy policy checkbox ");
    }

    public void clickOnContinueButton() {
       clickOnElement(continueBtn);
       log.info("Click on continue button ");
    }

}
