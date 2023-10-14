package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.CheckoutStepTwo;

public class CheckoutTwoSteps {

    protected WebDriver driver;
    private CheckoutStepTwo checkoutStepTwo;

    public CheckoutTwoSteps(WebDriver driver) {

        this.driver = driver;
        checkoutStepTwo = new CheckoutStepTwo(driver);
    }
}
