package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Login;
import saucedemo.pageobjects.Menu;
import saucedemo.steps.CartSteps;
import saucedemo.steps.CheckoutOneSteps;
import saucedemo.steps.CheckoutTwoSteps;
import saucedemo.steps.HeaderSteps;
import saucedemo.steps.LoginSteps;
import saucedemo.steps.OrderConfirmationSteps;
import saucedemo.steps.ProductsSteps;

public class EndToEndTests extends BaseTest{

    private Login login;
    private LoginSteps loginSteps;
    private ProductsSteps productsSteps;
    private CartSteps cartSteps;
    private CheckoutOneSteps checkoutOneSteps;
    private CheckoutTwoSteps checkoutTwoSteps;
    private OrderConfirmationSteps confirmationSteps;
    private HeaderSteps headerSteps;
    private Header header;
    private Menu menu;


    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        login = new Login();
        loginSteps = new LoginSteps();
        productsSteps = new ProductsSteps();
        cartSteps = new CartSteps();
        checkoutOneSteps = new CheckoutOneSteps();
        checkoutTwoSteps = new CheckoutTwoSteps();
        confirmationSteps = new OrderConfirmationSteps();
        headerSteps = new HeaderSteps();
        header = new Header();
        menu = new Menu();

        loginSteps.loginWithUsernameRegular();
    }

    /**
     * This test will get one random product, add it to the cart and perform checkout.
     * There is no need to clear the cart from existing products because
     * the user is unique to the browser instance. (each test has it`s own browser instance)
     */
    @Test()
    public void endToEndPlaceOrderWithOneProduct(){

        productsSteps.addProductToCartAndGoToCart(randomNumber1To6());
        cartSteps.pressCheckoutButton();
        checkoutOneSteps.fillInInputFieldsAndPressNext();
        checkoutTwoSteps.checkTotalPriceValue();
        checkoutTwoSteps.pressFinishButton();
        confirmationSteps.checkPageIsDisplayed();
        confirmationSteps.clickBackHomeButton();
        headerSteps.checkPageIsDisplayed();
        productsSteps.checkPageIsDisplayed();
        header.clickMenuButton();
        waitImplicit(1);//todo      remove after explicit wait implementation
        menu.clickOnLogoutOption();
        login.checkAllPageElementsAreDisplayed();
    }

    @Test
    public void endToEndPlaceOrderWithMultipleProductsCheckTotal(){



    }

}