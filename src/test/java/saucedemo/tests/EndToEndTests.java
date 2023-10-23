package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pageobjects.Cart;
import saucedemo.pageobjects.CheckoutStepTwo;
import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Login;
import saucedemo.pageobjects.Menu;
import saucedemo.pageobjects.OrderConfirmation;
import saucedemo.pageobjects.Product;
import saucedemo.pageobjects.Products;
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
    private saucedemo.pageobjects.Product product;
    private Products products;
    private ProductsSteps productsSteps;
    private CartSteps cartSteps;
    private Cart cart;
    private CheckoutOneSteps checkoutOneSteps;
    private CheckoutTwoSteps checkoutTwoSteps;
    private CheckoutStepTwo checkoutStepTwo;
    private OrderConfirmationSteps confirmationSteps;
    private OrderConfirmation confirmation;
    private HeaderSteps headerSteps;
    private Header header;
    private Menu menu;


    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        login = new Login();
        loginSteps = new LoginSteps();
        product = new Product();
        products = new Products();
        productsSteps = new ProductsSteps();
        cartSteps = new CartSteps();
        cart = new Cart();
        checkoutOneSteps = new CheckoutOneSteps();
        checkoutTwoSteps = new CheckoutTwoSteps();
        checkoutStepTwo = new CheckoutStepTwo();
        confirmationSteps = new OrderConfirmationSteps();
        confirmation = new OrderConfirmation();
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
    @Test(priority = 1)
    public void endToEndPlaceOrderWithOneProduct(){

        productsSteps.addProductToCartAndGoToCart(randomNumber0ToTotalAvailableProducts());
        cart.clickCheckoutButton();
        checkoutOneSteps.fillInInputFieldsAndPressNext();
        checkoutTwoSteps.checkTotalPriceValue();
        checkoutStepTwo.clickFinishButton();
        confirmationSteps.checkPageIsDisplayed();
        confirmation.clickBackHomeButton();
        headerSteps.checkPageIsDisplayed();
        productsSteps.checkPageIsDisplayed();
        header.clickMenuButton();
        menu.clickOnLogoutOption();
        login.checkAllPageElementsAreDisplayed();
    }

    @Test(priority = 2)
    public void endToEndPlaceOrderWithMultipleProductsCheckTotal(){

        int indexForFirst = randomNumber0ToTotalAvailableProducts();
        int indexForSecond = randomNumber0ToTotalAvailableProducts();
        int indexForThird = randomNumber0ToTotalAvailableProducts();

        System.out.println("indexes: " + indexForFirst + ", " + indexForSecond + ", " + indexForThird);

        productsSteps.setUpTheProducts();
        products.clickProductImage(indexForFirst);

        //todo  add validations for the product
        product.clickAddToCart();
        //todo  add validations for the remove from cart button
        //todo  add validation for the cart icon value

        product.clickBackToProducts();
        products.clickAddToCart(indexForSecond);
        //todo  add validations for the cart icon value
        products.clickAddToCart(indexForThird);
        header.clickCartButton();

        //todo  need to refactor this method, the locator is
        cart.clickProductRemoveButton(1);
        cart.clickCheckoutButton();
        checkoutOneSteps.fillInInputFieldsAndPressNext();

        //todo  need to cover the case where there are multiple products in the cart
        checkoutTwoSteps.checkTotalPriceValue();
        checkoutStepTwo.clickFinishButton();
        confirmationSteps.checkPageIsDisplayed();
        confirmation.clickBackHomeButton();
        headerSteps.checkPageIsDisplayed();
        productsSteps.checkPageIsDisplayed();

    }

}