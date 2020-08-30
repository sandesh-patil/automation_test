package com.myStore.stepdefinitions.homepage;

import com.myStore.pages.homepage.PaymentPage;
import com.myStore.stepdefinitions.Hooks;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PaymentPageSteps {

    public static WebDriver driver;
    PaymentPage paymentPage;


    public PaymentPageSteps() {
        driver = Hooks.driver;
    }


    @When("^I select payment method as \"([^\"]*)\"$")
    public void iSelectPaymentMethodAs(String payType) {
        paymentPage = new PaymentPage(driver);

        switch (payType) {
            case "bankwire":
                paymentPage.selectPayByBankWire();
                break;
            case "cheque":
                paymentPage.selectPayByCheck();
                break;
        }

    }

    @When("^I click on confirm order$")
    public void iClickOnConfirmOrder() {
        paymentPage.selectConfirmOrder();
    }


    @Then("^I should see my order successfully placed$")
    public void iShouldSeeMyOrderSuccessfullyPlaced() {
        Assert.assertTrue("Order confirm page is incorrect", paymentPage.getOrderConfirmText().equals("ORDER CONFIRMATION"));
        Assert.assertTrue("Order confirm page title is incorrect", paymentPage.getPageTitle().contains("Order confirmation - My Store"));

    }

}
