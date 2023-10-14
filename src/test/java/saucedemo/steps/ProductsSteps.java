package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Products;

public class ProductsSteps {

    protected WebDriver driver;
    private Products products;
    private Header header;

    public ProductsSteps(WebDriver driver) {

        this.driver = driver;
        products = new Products(driver);
        header = new Header(driver);
    }


    public ProductsSteps addProductToCartAndGoToCart(int index){

        products.clickAddToCart(index);
        header.clickCartButton();
        return this;
    }

}
