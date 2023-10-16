package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.CheckoutStepOne;

import java.util.Random;

import static saucedemo.base.BasePageObject.randomAlphaNumeric;

public class CheckoutOneSteps {

    private CheckoutStepOne checkoutStepOne;

    public CheckoutOneSteps() {

        checkoutStepOne = new CheckoutStepOne();
    }

    public CheckoutOneSteps fillInInputFieldsAndPressNext(){

        checkoutStepOne.inputFirstName(randomAlphaNumeric(3)).
                inputLastName(randomAlphaNumeric(3)).
                inputPostalCode(randomAlphaNumeric(3));
        checkoutStepOne.clickContinueButton();
        return this;
    }
}
