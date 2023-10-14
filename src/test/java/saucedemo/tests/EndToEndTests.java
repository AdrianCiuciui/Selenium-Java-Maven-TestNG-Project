package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.steps.*;

public class EndToEndTests extends BaseTest{

    private LoginSteps loginSteps;
    private ProductsSteps productsSteps;
    private CartSteps cartSteps;
    private CheckoutOneSteps checkoutOneSteps;
    private CheckoutTwoSteps checkoutTwoSteps;
    private OrderConfirmationSteps confirmationSteps;


    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
        cartSteps = new CartSteps(driver);
        checkoutOneSteps = new CheckoutOneSteps(driver);
        checkoutTwoSteps = new CheckoutTwoSteps(driver);
        confirmationSteps = new OrderConfirmationSteps(driver);

        loginSteps.loginWithUsernameRegular();
    }

    @Test
    public void endToEndPlaceOrderWithOneProduct(){

        //todo  need to add validators for current page
        //todo  need to add clear existing cart products
        productsSteps.addProductToCartAndGoToCart(1);
        cartSteps.pressCheckoutButton();




    }

    @Test
    public void endToEndPlaceOrderWithMultipleProductsCheckTotal(){



    }

}
