package saucedemo.steps;

import saucedemo.base.BasePageObject;
import saucedemo.base.Item;
import saucedemo.pageobjects.Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductSteps extends BasePageObject {


    Product product = new Product();

    public void checkPageElementsAreDisplayedExceptCartButtons(){

        assertThat(product.isProductTitleDisplayed(), is(true));
        assertThat(product.isDescriptionDisplayed(), is(true));
        assertThat(product.isPriceDisplayed(), is(true));
        assertThat(product.isImageDisplayed(), is(true));
        assertThat(product.isReturnButtonDisplayed(), is(true));
    }

    public void checkTheProductPageContents(Item item){

        assertThat("The product name does not match", product.getProductName(), is(item.getProductName()));
        assertThat("The product description does not match", product.getProductDescription(), is(item.getDescription()));
        assertThat("The product price does not match", product.getProductPrice().substring(1), is(item.getPrice()));
    }
}
