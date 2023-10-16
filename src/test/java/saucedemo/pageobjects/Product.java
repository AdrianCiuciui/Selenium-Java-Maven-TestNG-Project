package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Product extends BasePageObject {

    //todo      the add/remove buttons could not work due to identified area bigger than the button
    private final By buttonAddToCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_primary')]");
    private final By buttonRemoveFromCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_secondary')]");
    private final By buttonBackToProducts = xpath("//button[@id='back-to-products']");
    private final By labelProductName = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductDescription = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductPrice = xpath("//div[@class='inventory_details_price']");


    public Product(WebDriver driver) {
        super(driver);
    }


    public Product clickBackToProducts(){

        driver.findElement(buttonBackToProducts).click();
        return this;
    }

    public Product clickAddToCart(){

        driver.findElement(buttonAddToCart).click();
        return this;
    }

    public Product clickRemoveFromCart(){

        driver.findElement(buttonRemoveFromCart).click();
        return this;
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