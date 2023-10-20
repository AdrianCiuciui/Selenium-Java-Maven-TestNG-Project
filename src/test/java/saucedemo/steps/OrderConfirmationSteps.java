package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.OrderConfirmation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderConfirmationSteps {
    private OrderConfirmation orderConfirmation;

    public OrderConfirmationSteps() {
        this.orderConfirmation = new OrderConfirmation();
    }

    public OrderConfirmationSteps checkPageIsDisplayed(){

        boolean isPageDisplayed = (
                orderConfirmation.isMessageDescriptionDisplayed() &&
                orderConfirmation.isMessageHeaderDisplayed() &&
                orderConfirmation.isSuccessImageDisplayed()
                );
        assertThat(isPageDisplayed, is(true));
        return this;
    }

    public OrderConfirmationSteps clickBackHomeButton(){

        orderConfirmation.clickBackHomeButton();
        return this;
    }
}
