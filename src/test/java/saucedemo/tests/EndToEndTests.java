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
import saucedemo.steps.LoginSteps;
import saucedemo.steps.OrderConfirmationSteps;
import saucedemo.steps.ProductSteps;
import saucedemo.steps.ProductsSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EndToEndTests extends BaseTest{

    private Login login;
    private LoginSteps loginSteps;
    private saucedemo.pageobjects.Product product;
    private ProductSteps productSteps;
    private Products products;
    private ProductsSteps productsSteps;
    private CartSteps cartSteps;
    private Cart cart;
    private CheckoutOneSteps checkoutOneSteps;
    private CheckoutTwoSteps checkoutTwoSteps;
    private CheckoutStepTwo checkoutStepTwo;
    private OrderConfirmationSteps confirmationSteps;
    private OrderConfirmation confirmation;
    private Header header;
    private Menu menu;


    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        login = new Login();
        loginSteps = new LoginSteps();
        product = new Product();
        productSteps = new ProductSteps();
        products = new Products();
        productsSteps = new ProductsSteps();
        cartSteps = new CartSteps();
        cart = new Cart();
        checkoutOneSteps = new CheckoutOneSteps();
        checkoutTwoSteps = new CheckoutTwoSteps();
        checkoutStepTwo = new CheckoutStepTwo();
        confirmationSteps = new OrderConfirmationSteps();
        confirmation = new OrderConfirmation();
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
        header.checkTitleIsDisplayed();
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
        int numberOfProductsInCart = 0;

        productsSteps.setUpTheProducts();
        products.clickProductImage(indexForFirst);
        productSteps.checkPageElementsAreDisplayedExceptCartButtons();
        assertThat(product.isAddToCartButtonDisplayed(), is(true));
        productSteps.checkTheProductPageContents(productsOrdered.get(indexForFirst));
        assertThat(header.isBadgeDisplayed(), is(false));
        product.clickAddToCart();
        assertThat(product.isRemoveFromCartButtonDisplayed(), is(true));
        assertThat(header.isBadgeDisplayed(), is(true));
        assertThat(header.getCartBadgeValue(), is(++numberOfProductsInCart));
        product.clickBackToProducts();
        products.clickAddToCart(indexForSecond);
        assertThat(header.getCartBadgeValue(), is(++numberOfProductsInCart));
        products.clickAddToCart(indexForThird);
        assertThat(header.getCartBadgeValue(), is(++numberOfProductsInCart));
        header.clickCartButton();
        cart.clickProductRemoveButton(0);
        cart.clickCheckoutButton();
        checkoutOneSteps.fillInInputFieldsAndPressNext();
        checkoutTwoSteps.checkTotalPriceValue();
        checkoutTwoSteps.checkTotalSumValueOfProducts();
        checkoutStepTwo.clickFinishButton();
        confirmationSteps.checkPageIsDisplayed();
        assertThat(header.isBadgeDisplayed(), is(false));
        confirmation.clickBackHomeButton();
        header.checkTitleIsDisplayed();
        productsSteps.checkPageIsDisplayed();
    }

}