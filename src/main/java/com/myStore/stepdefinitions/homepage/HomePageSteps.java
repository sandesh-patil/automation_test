package com.myStore.stepdefinitions.homepage;


import com.myStore.pages.homepage.HomePage;
import com.myStore.stepdefinitions.Hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Data;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class HomePageSteps {
    public static WebDriver driver;
    HomePage homePage;
    Properties prop = new Properties();
    Data data;


    public HomePageSteps() {
        driver = Hooks.driver;
    }

    @Test(dataProvider = "searchData")
    @Given("^I land on my store homepage$")
    public void iLandOnMyStoreHomepage() throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        prop.load(inputStream);
        String url = prop.getProperty("testUrl");
        driver.get(url);
    }

    @When("^I select any \"([^\"]*)\" items from the display on homepage$")
    public void iSelectAnyItemsFromTheDisplayOnHomepage(int itemCount) {
        homePage = new HomePage(driver);
        homePage.selectItemsToCart(itemCount);
    }

    @And("^I proceed to checkout$")
    public void iProceedToCheckout() {
        Assert.assertTrue("Proceed to checkout Button not displaying", homePage.proceedToCheckoutMainBtn().isDisplayed());
        homePage.clickProceedToCheckoutMainButton();
    }

    @And("^I click to proceed to checkout$")
    public void iClickToProceedToCheckout() {

    }

    @And("^I select to register as new user to make payment$")
    public void iSelectToRegisterAsNewUserToMakePayment() {

    }

    @Then("^I should be able to successfully place order$")
    public void iShouldBeAbleToSuccessfullyPlaceOrder() {

    }


    /***********
     *  Need to enter test account login username and password details here to login and proceed to purchase
     *  ********/


}


