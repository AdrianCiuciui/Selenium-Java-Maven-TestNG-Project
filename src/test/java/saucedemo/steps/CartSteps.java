package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Cart;

public class CartSteps {

    private final Cart cart;


    public CartSteps() {
        cart = new Cart();
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
