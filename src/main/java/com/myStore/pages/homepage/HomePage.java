package com.myStore.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    public WebDriver driver;

    private final By addToCartButton = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default > span");
    private final By continueShoppingButton = By.cssSelector("div#layer_cart div.button-container > span > span");
    private final By itemContainer = By.cssSelector("div.product-container");
    private final By proceedToCheckOutBtn = By.cssSelector("div#layer_cart a > span");
    private final By proceedCheckoutMainBtn = By.cssSelector("div#center_column a.button.btn.btn-default.standard-checkout.button-medium > span");

    /**
     * Constructor to initialise the driver
     *
     * @param driver
     */

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectItemsToCart(int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            if (i == itemCount - 1) {
                selectAddToCart(i);
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutBtn));
                driver.findElement(proceedToCheckOutBtn).click();
                break;
            }
            selectAddToCart(i);
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            driver.findElement(continueShoppingButton).click();
        }
    }

    public void selectAddToCart(int i) {
        List<WebElement> products = driver.findElements(itemContainer);
        List<WebElement> addToCartButtons = driver.findElements(addToCartButton);

        Actions action = new Actions(driver);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(itemContainer));
        action.moveToElement(products.get(i))
                .moveToElement(addToCartButtons.get(i))
                .click().build().perform();
    }

    public WebElement proceedToCheckoutMainBtn() {
        return driver.findElement(proceedCheckoutMainBtn);
    }

    public void clickProceedToCheckoutMainButton() {
        Actions action = new Actions(driver);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(proceedCheckoutMainBtn));
        action.moveToElement(proceedToCheckoutMainBtn()).click().build().perform();
    }
}
