package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.OrderConfirmation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderConfirmationSteps {

    protected WebDriver driver;
    private OrderConfirmation orderConfirmation;

    public OrderConfirmationSteps(WebDriver driver) {

        this.driver = driver;
        this.orderConfirmation = new OrderConfirmation(driver);
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
