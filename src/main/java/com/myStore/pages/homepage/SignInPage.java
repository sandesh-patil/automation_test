package com.myStore.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SignInPage {
    public WebDriver driver;
    Properties prop = new Properties();
    InputStream inputStream = new FileInputStream("src/test/resources/config.properties");


    private final By emailIdField = By.cssSelector("input#email_create");
    private final By createAccountBtn = By.cssSelector("button#SubmitCreate > span");
    private final By firstNameField = By.cssSelector("input#customer_firstname");
    private final By genderRadioBtn = By.cssSelector("input#id_gender1");
    private final By lastNameField = By.cssSelector("input#customer_lastname");
    private final By passwordField = By.cssSelector("input#passwd");
    private final By dateItem = By.cssSelector("select#days");
    private final By monthItem = By.cssSelector("select#months");
    private final By yearItem = By.cssSelector("select#years");
    private final By firstNameAddressField = By.cssSelector("input#firstname");
    private final By lastNameAddressField = By.cssSelector("input#lastname");
    private final By companyField = By.cssSelector("input#company");
    private final By addressField = By.cssSelector("input#address1");
    private final By cityField = By.cssSelector("input#city");
    private final By stateField = By.cssSelector("select#id_state");
    private final By zipCodeField = By.cssSelector("input#postcode");
    private final By countryField = By.cssSelector("select#id_country");
    private final By mobileNoField = By.cssSelector("input#phone_mobile");
    private final By registerButton = By.cssSelector("button#submitAccount > span");
    private final By proceedToCheckOut = By.cssSelector("button.btn.btn-default.button-medium");
    private final By proceedToCheckOutShipping = By.cssSelector(".standard-checkout.button-medium");
    private final By termsCheckBox = By.cssSelector("input#cgv");
    private final By emailAlreadyRegisterField = By.cssSelector("input#email");
    private final By passwordAlreadyRegisterField = By.cssSelector("input#passwd");
    private final By signInButton = By.cssSelector("button#SubmitLogin > span");


    /**
     * Constructor to initialise the driver
     *
     * @param driver
     */

    public SignInPage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }


    public WebElement emailFieldSigninPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(emailIdField));
        return driver.findElement(emailIdField);
    }

    public void clickCreateAccountBtn() {
        WebElement createAccountButton = driver.findElement(createAccountBtn);
        Actions action = new Actions(driver);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        action.moveToElement(createAccountButton).click().build().perform();

    }

    public void enterPersonalInfo() throws IOException {
        prop.load(inputStream);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

        driver.findElement(genderRadioBtn).click();

        driver.findElement(firstNameField).sendKeys(prop.getProperty("firstName"));


        driver.findElement(lastNameField).sendKeys(prop.getProperty("lastName"));


        driver.findElement(passwordField).sendKeys(prop.getProperty("password"));


        selectDateOfBirth((prop.getProperty("day")));


        selectMonthOfBirth(prop.getProperty("month"));


        selectYearOfBirth(prop.getProperty("year"));


        driver.findElement(firstNameAddressField).sendKeys(prop.getProperty("firstNameAddress"));


        driver.findElement(lastNameAddressField).sendKeys(prop.getProperty("lastNameAddress"));


        driver.findElement(companyField).sendKeys(prop.getProperty("company"));


        driver.findElement(addressField).sendKeys(prop.getProperty("address"));


        driver.findElement(cityField).sendKeys(prop.getProperty("city"));


        selectCountry(prop.getProperty("country"));


        selectState(prop.getProperty("state"));


        driver.findElement(zipCodeField).sendKeys(prop.getProperty("zipCode"));


        driver.findElement(mobileNoField).sendKeys(prop.getProperty("mobileNo"));
    }


    public void selectDateOfBirth(String day) {
        Select date = new Select(driver.findElement(dateItem));
        date.selectByValue(day);
    }

    public void selectMonthOfBirth(String month) {
        Select monthOfBirth = new Select(driver.findElement(monthItem));
        monthOfBirth.selectByVisibleText(month);
    }

    public void selectYearOfBirth(String year) {
        Select yearOfBirth = new Select(driver.findElement(yearItem));
        yearOfBirth.selectByValue(year);
    }

    public void selectState(String state) {
        Select stateAddress = new Select(driver.findElement(stateField));
        stateAddress.selectByVisibleText(state);
    }

    public void selectCountry(String country) {
        Select countryAddress = new Select(driver.findElement(countryField));
        countryAddress.selectByVisibleText(country);
    }

    public void clickRegisterButton() {
        Actions action = new Actions(driver);
        WebElement registerBtn = driver.findElement(registerButton);
        action.moveToElement(registerBtn).click().build().perform();
    }

    public void proceedToCheckOutAfterRegister() {
        Actions action = new Actions(driver);
        WebElement proceedToCheckOutBtn = driver.findElement(proceedToCheckOut);
        action.moveToElement(proceedToCheckOutBtn).click().build().perform();
    }

    public void proceedToCheckOutShippingdetails() {
        Actions action = new Actions(driver);
        WebElement termsCheckBoxElement = driver.findElement(termsCheckBox);
        action.moveToElement(termsCheckBoxElement).click().build().perform();

        WebElement proceedToChkOutShipping = driver.findElement(proceedToCheckOutShipping);
        action.moveToElement(proceedToChkOutShipping).click().build().perform();
    }


    public void emailIdAlreadyRegistered() throws IOException {
        prop.load(inputStream);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(emailAlreadyRegisterField));
        driver.findElement(emailAlreadyRegisterField).sendKeys(prop.getProperty("emailIdAlreadyRegistered"));
    }

    public void enterPasswordAlreadyRegistered() throws IOException {
        prop.load(inputStream);
        driver.findElement(passwordAlreadyRegisterField).sendKeys(prop.getProperty("passwordAlreadyRegistered"));
    }

    public void clickSignInButton() {
        Actions action = new Actions(driver);
        WebElement signInBtn = driver.findElement(signInButton);
        action.moveToElement(signInBtn).click().build().perform();

    }

}
