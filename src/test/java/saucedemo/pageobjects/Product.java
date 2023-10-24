package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Product extends BasePageObject {

    private final By buttonAddToCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_primary')]");
    private final By buttonRemoveFromCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_secondary')]");
    private final By buttonBackToProducts = By.id("back-to-products");
    private final By labelProductName = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductDescription = xpath("//div[@class='inventory_details_desc large_size']");
    private final By labelProductPrice = xpath("//div[@class='inventory_details_price']");
    private final By productImage = xpath("//img[@class='inventory_details_img']");

    public void clickBackToProducts(){
        driver.findElement(buttonBackToProducts).click();
    }

    public void clickAddToCart(){
        driver.findElement(buttonAddToCart).click();
    }

    public void clickRemoveFromCart(){
        driver.findElement(buttonRemoveFromCart).click();
    }

    public String getProductName(){
        return driver.findElement(labelProductName).getText();
    }

    public String getProductDescription(){
        return driver.findElement(labelProductDescription).getText();
    }

    public String getProductPrice(){
        return driver.findElement(labelProductPrice).getText();
    }

    public boolean isProductTitleDisplayed(){

        return driver.findElement(labelProductName).isDisplayed();
    }

    public boolean isDescriptionDisplayed(){

        return driver.findElement(labelProductDescription).isDisplayed();
    }

    public boolean isPriceDisplayed(){

        return driver.findElement(labelProductPrice).isDisplayed();
    }

    public boolean isImageDisplayed(){

        return driver.findElement(productImage).isDisplayed();
    }

    public boolean isReturnButtonDisplayed(){

        return driver.findElement(buttonBackToProducts).isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed(){

        return driver.findElement(buttonAddToCart).isDisplayed();
    }

    public boolean isRemoveFromCartButtonDisplayed(){

        return driver.findElement(buttonRemoveFromCart).isDisplayed();
    }

}