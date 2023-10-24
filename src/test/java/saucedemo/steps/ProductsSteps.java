package saucedemo.steps;

import saucedemo.base.Item;
import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Products;

import java.util.stream.IntStream;

import static saucedemo.base.BaseTest.getTotalNumberOfDisplayedProducts;
import static saucedemo.base.BaseTest.productsOrdered;

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

    /**
     * This method must and can only be run while on the Products page.
     * It assigns values from the page into objects so that are more intractable.
     */
    private Item setProductInformation(int index){

        Item item = new Item();
        item.setId(index);

        String description = products.getProductDescription(index);
        item.setDescription(description);

        String price = products.getProductPrice(index);
        item.setPrice(price);

        String title = products.getProductTitle(index);
        item.setProductName(title);

        boolean isProductInCart = products.isProductInCart(index);
        item.setInCart(isProductInCart);

        return item;
    }

    public void setUpTheProducts(){

        IntStream.range(0, getTotalNumberOfDisplayedProducts()).forEach(index -> productsOrdered.add(setProductInformation(index)));
    }

    /**
     * For debugging purposes
     *
     * @param item An instance of the Product class
     */
    public void printProductInformation(Item item){

        System.out.println("\nID " + item.getId());
        System.out.println("Title: " + item.getProductName());
        System.out.println("Description: " + item.getDescription());
        System.out.println("Price: " + item.getPrice());
        System.out.println("In cart: " + item.isInCart());

    }

}