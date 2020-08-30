package com.myStore.stepdefinitions.homepage;

import com.myStore.pages.homepage.SignInPage;
import com.myStore.stepdefinitions.Hooks;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SignInPageSteps {

    public static WebDriver driver;

    SignInPage signInPage;






    public SignInPageSteps() {
        driver = Hooks.driver;
    }



    @And("^I sign in and register as a new user$")
    public void iSignInAndRegisterAsANewUser() throws IOException {
        signInPage = new SignInPage(driver);
        int userName = (int) (Math.random() * Integer.MAX_VALUE);
        String emailId = "testUser" + userName + "@gmail.com";

        signInPage.emailFieldSigninPage().sendKeys(emailId);

        signInPage.clickCreateAccountBtn();

        signInPage.enterPersonalInfo();

        signInPage.clickRegisterButton();

    }

    @And("^I click on proceed to checkout after registering$")
    public void iClickOnProceedToCheckoutAfterRegistering()  {
        signInPage.proceedToCheckOutAfterRegister();

        signInPage.proceedToCheckOutShippingdetails();

    }


    @And("^I sign in as already registered user$")
    public void iSignInAsAlreadyRegisteredUser() throws InterruptedException, IOException {
        signInPage = new SignInPage(driver);
        signInPage.emailIdAlreadyRegistered();

        signInPage.enterPasswordAlreadyRegistered();

        signInPage.clickSignInButton();

    }
}
