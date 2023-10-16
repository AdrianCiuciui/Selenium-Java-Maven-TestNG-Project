package saucedemo.steps;

import saucedemo.base.BasePageObject;
import saucedemo.pageobjects.Cart;

public class CartSteps extends BasePageObject {

    private final Cart cart;


    public CartSteps() {
        cart = new Cart();
    }

    public void pressCheckoutButton(){
        cart.clickCheckoutButton();
    }

    public void pressContinueShoppingButton(){
        cart.clickContinueShoppingButton();
    }

    public void removeProduct(int index){
        cart.clickProductRemoveButton(index);
    }
}
