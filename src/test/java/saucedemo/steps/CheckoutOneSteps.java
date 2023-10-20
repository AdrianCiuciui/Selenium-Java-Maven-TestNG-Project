package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;
import saucedemo.pageobjects.CheckoutStepOne;

import static saucedemo.base.BasePageObject.randomAlphaNumeric;

public class CheckoutOneSteps extends BasePageObject {
    private CheckoutStepOne checkoutStepOne;

    public CheckoutOneSteps() {
        checkoutStepOne = new CheckoutStepOne();
    }

    public void fillInInputFieldsAndPressNext(){

        checkoutStepOne.inputFirstName(randomAlphaNumeric(3));
        checkoutStepOne.inputLastName(randomAlphaNumeric(3));
        checkoutStepOne.inputPostalCode(randomAlphaNumeric(3));
        checkoutStepOne.clickContinueButton();
    }
}
