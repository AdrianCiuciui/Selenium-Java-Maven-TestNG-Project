package saucedemo.steps;

import org.openqa.selenium.WebDriver;
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



    public ProductsSteps checkPageIsDisplayed(){

        assertThat(header.isTitleDisplayed(), is(true));
        assertThat(products.isPageDisplayed(), is(true));
        return this;
    }

    public ProductsSteps addProductToCartAndGoToCart(int index){

        products.clickAddToCart(index);
        header.clickCartButton();

        return this;
    }

}