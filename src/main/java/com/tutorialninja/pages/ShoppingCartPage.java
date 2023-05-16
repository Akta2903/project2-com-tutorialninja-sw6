package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement  currencyButton ;
    By sterlingPound = By.xpath("//ul[@class = 'dropdown-menu']/li");

    public String getShoppingCartText() {

        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        log.info("Getting Product name " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        log.info("Getting delivery date " + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
       log.info("Getting model " + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        log.info("Getting total " + total.toString());


    return getTextFromElement(total);
    }
    public void changeCurrency(String text)

    {
        clickOnElement(currencyButton);
        selectByContainsTextFromListOfElements(sterlingPound,text);

    }
    public void changeQuantity(String qty) {
        sendTextToElement(qtyField, qty);
        log.info("Update the quantity " + qty);
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
        log.info("Click on update quantity " + qtyUpdateBtn );
    }

    public String getSuccessModifiedMessage() {
       log.info("Getting successfully modified message " + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }


}
