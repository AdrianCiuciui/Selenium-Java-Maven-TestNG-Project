package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.OrderConfirmation;

public class OrderConfirmationSteps {

    protected WebDriver driver;
    private OrderConfirmation orderConfirmation;

    public OrderConfirmationSteps(WebDriver driver) {

        this.driver = driver;
        this.orderConfirmation = new OrderConfirmation(driver);
    }
}
