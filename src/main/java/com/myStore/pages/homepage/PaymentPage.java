package com.myStore.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    public WebDriver driver;

    private final By payByBankWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private final By payBycheck = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
    private final By confirmOrder = By.cssSelector("p#cart_navigation span");
    private final By orderConfirmText = By.cssSelector("h1.page-heading");


    /**
     * Constructor to initialise the driver
     *
     * @param driver
     */

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectPayByBankWire() {
        WebElement payByBankWireMethod = driver.findElement(payByBankWire);
        Actions action = new Actions(driver);
        action.moveToElement(payByBankWireMethod).click().build().perform();
    }

    public void selectPayByCheck() {
        WebElement payByCheckMethod = driver.findElement(payBycheck);
        Actions action = new Actions(driver);
        action.moveToElement(payByCheckMethod).click().build().perform();
    }

    public void selectConfirmOrder() {
        WebElement confirmOrderBtn = driver.findElement(confirmOrder);
        Actions action = new Actions(driver);
        action.moveToElement(confirmOrderBtn).click().build().perform();
    }

    public String getOrderConfirmText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmText));
        return driver.findElement(orderConfirmText).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
