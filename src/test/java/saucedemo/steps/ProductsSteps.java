package saucedemo.steps;

import saucedemo.base.Product;
import saucedemo.pageobjects.Header;
import saucedemo.pageobjects.Products;

import java.util.stream.IntStream;

import static saucedemo.base.BaseTest.getTotalNumberOfProducts;
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
    private Product setProductInformation(int index){

        Product product = new Product();
        product.setId(index);

        String description = products.getProductDescription(index);
        product.setDescription(description);

        String price = products.getProductPrice(index);
        product.setPrice(price);

        String title = products.getProductTitle(index);
        product.setTitle(title);

        boolean isProductInCart = products.isProductInCart(index);
        product.setInCart(isProductInCart);

        return product;
    }

    public void setUpTheProducts(){

        IntStream.range(0, getTotalNumberOfProducts()).forEach(index -> productsOrdered.add(setProductInformation(index)));
    }

    /**
     * For debugging purposes
     *
     * @param product An instance of the Product class
     */
    public void printProductInformation(Product product){

        System.out.println("\nID " + product.getId());
        System.out.println("Title: " + product.getTitle());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("In cart: " + product.isInCart());

    }


}