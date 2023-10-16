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
    private HeaderSteps headerSteps;


    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        loginSteps = new LoginSteps();
        productsSteps = new ProductsSteps();
        cartSteps = new CartSteps();
        checkoutOneSteps = new CheckoutOneSteps();
        checkoutTwoSteps = new CheckoutTwoSteps();
        confirmationSteps = new OrderConfirmationSteps();
        headerSteps = new HeaderSteps();

        loginSteps.loginWithUsernameRegular();
    }

    /**
     * This test will get one random product, add it to the cart and perform checkout.
     * There is no need to clear the cart from existing products because
     * the user is unique to the browser instance. (each test has it`s own browser instance)
     */
    @Test()
    public void endToEndPlaceOrderWithOneProduct(){

        productsSteps.
                addProductToCartAndGoToCart(randomNumber1To6());
        cartSteps.
                pressCheckoutButton();
        checkoutOneSteps.
                fillInInputFieldsAndPressNext();
        checkoutTwoSteps.
                checkTotalPriceValue().
                pressFinishButton();
        confirmationSteps.
                checkPageIsDisplayed().
                clickBackHomeButton();
        headerSteps.
                checkPageIsDisplayed();
        productsSteps.
                checkPageIsDisplayed();
    }

    @Test
    public void endToEndPlaceOrderWithMultipleProductsCheckTotal(){



    }

}