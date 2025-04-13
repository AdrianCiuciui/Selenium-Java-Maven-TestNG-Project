package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pageobjects.*;
import saucedemo.steps.*;

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
    private Footer footer;


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
        footer = new Footer();

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
        footer.checkFooterIsDisplayed();
        footer.checkSocialsAreDisplayed();
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
        assertThat("The add to cart button is not displayed", product.isAddToCartButtonDisplayed(), is(true));
        productSteps.checkTheProductPageContents(productsOrdered.get(indexForFirst));
        assertThat("The badge is displayed over the cart icon", header.isBadgeDisplayed(), is(false));
        product.clickAddToCart();
        assertThat("The remove from cart button is not displayed", product.isRemoveFromCartButtonDisplayed(), is(true));
        assertThat("The badge is not displayed over the cart icon", header.isBadgeDisplayed(), is(true));
        assertThat("The badge value is not as expected", header.getCartBadgeValue(), is(++numberOfProductsInCart));
        product.clickBackToProducts();
        products.clickAddToCart(indexForSecond);
        assertThat("The badge value is not as expected", header.getCartBadgeValue(), is(++numberOfProductsInCart));
        products.clickAddToCart(indexForThird);
        assertThat("The badge value is not as expected", header.getCartBadgeValue(), is(++numberOfProductsInCart));
        header.clickCartButton();
        cart.clickProductRemoveButton(0);
        cart.clickCheckoutButton();
        checkoutOneSteps.fillInInputFieldsAndPressNext();
        checkoutTwoSteps.checkTotalPriceValue();
        checkoutTwoSteps.checkTotalSumValueOfProducts();
        checkoutStepTwo.clickFinishButton();
        confirmationSteps.checkPageIsDisplayed();
        assertThat("The badge is displayed over the cart icon", header.isBadgeDisplayed(), is(false));
        confirmation.clickBackHomeButton();
        header.checkTitleIsDisplayed();
        productsSteps.checkPageIsDisplayed();
    }

}