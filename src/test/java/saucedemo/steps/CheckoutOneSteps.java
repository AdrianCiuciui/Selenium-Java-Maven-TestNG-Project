package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.CheckoutStepOne;

import static saucedemo.base.BasePageObject.randomAlphaNumeric;

public class CheckoutOneSteps {

    protected WebDriver driver;
    private CheckoutStepOne checkoutStepOne;

    public CheckoutOneSteps(WebDriver driver) {

        this.driver = driver;
        checkoutStepOne = new CheckoutStepOne(driver);
    }

    public CheckoutOneSteps fillInInputFieldsAndPressNext(){

        checkoutStepOne.inputFirstName(randomAlphaNumeric(3)).
                inputLastName(randomAlphaNumeric(3)).
                inputPostalCode(randomAlphaNumeric(3));
        checkoutStepOne.clickContinueButton();
        return this;
    }
}
