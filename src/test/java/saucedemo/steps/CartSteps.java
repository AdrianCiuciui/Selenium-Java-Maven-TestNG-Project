package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Cart;

public class CartSteps {

    protected WebDriver driver;
    private final Cart cart;


    public CartSteps(WebDriver driver) {

        this.driver = driver;
        cart = new Cart(driver);
    }

    public CartSteps pressCheckoutButton(){

        cart.clickCheckoutButton();
        return this;
    }

    public CartSteps pressContinueShoppingButton(){

        cart.clickContinueShoppingButton();
        return this;
    }

    public CartSteps removeProduct(int index){

        cart.clickProductRemoveButton(index);
        return this;
    }





}
