package saucedemo.steps;

import saucedemo.pageobjects.OrderConfirmation;


public class OrderConfirmationSteps {
    private OrderConfirmation orderConfirmation;

    public OrderConfirmationSteps() {
        this.orderConfirmation = new OrderConfirmation();
    }

    public void checkPageIsDisplayed(){

        orderConfirmation.checkMessageDescriptionIsDisplayed();
        orderConfirmation.checkMessageHeaderIsDisplayed();
        orderConfirmation.checkSuccessImageIsDisplayed();
    }

    public void clickBackHomeButton(){

        orderConfirmation.clickBackHomeButton();
    }
}
