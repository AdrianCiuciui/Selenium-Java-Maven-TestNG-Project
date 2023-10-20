package saucedemo.steps;

import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductsSteps {
    private final Products products;
    private final Header header;

    public ProductsSteps() {
        products = new Products();
        header = new Header();
    }



    public void checkPageIsDisplayed(){

        header.checkTitleIsDisplayed();
        products.checkPageIsDisplayed();
    }

    public void addProductToCartAndGoToCart(int index){

        products.clickAddToCart(index);
        header.clickCartButton();
    }

}