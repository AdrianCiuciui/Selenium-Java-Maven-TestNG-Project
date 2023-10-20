package saucedemo.steps;

import saucedemo.base.BasePageObject;
import saucedemo.pageobjects.CheckoutStepOne;

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
