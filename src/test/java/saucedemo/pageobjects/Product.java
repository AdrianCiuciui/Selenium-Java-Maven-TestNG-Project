package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Product extends BasePageObject {

    private final By buttonAddToCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_primary')]");
    private final By buttonRemoveFromCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_secondary')]");
    private final By buttonBackToProducts = xpath("//button[@id='back-to-products']");
    private final By labelProductName = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductDescription = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductPrice = xpath("//div[@class='inventory_details_price']");

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

}