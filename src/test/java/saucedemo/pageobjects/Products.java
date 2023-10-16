package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

public class Products extends BasePageObject {

    private final String buttonProductAllSection = "(//div[@class='inventory_item'])[%d]";
    private final String buttonProductImage = buttonProductAllSection + "//*[@class='inventory_item_img']//*[contains(@id,'item')]";
    private final String buttonProductTitle = buttonProductAllSection + "//*[@class='inventory_item_label']//*[contains(@id,'item')]";
    private final String buttonProductAddToCart = buttonProductAllSection + "//*[contains(@class,'btn_primary')]";
    private final String buttonProductRemoveFromCart = buttonProductAllSection + "//*[contains(@class,'btn_secondary')]";
    private final String labelProductDescription = buttonProductAllSection + "//*[@class='inventory_item_desc']";
    private final String labelProductPrice = buttonProductAllSection + "//*[@class='inventory_item_price']";


    public boolean isPageDisplayed(){

        return (
                driver.findElement(By.xpath(String.format(buttonProductAllSection, 1))).isDisplayed() &&
                driver.findElement(By.xpath(String.format(buttonProductImage, 2))).isDisplayed() &&
                driver.findElement(By.xpath(String.format(buttonProductTitle, 3))).isDisplayed() &&
                driver.findElement(By.xpath(String.format(buttonProductAddToCart, 4))).isDisplayed() &&
                driver.findElement(By.xpath(String.format(labelProductDescription, 5))).isDisplayed() &&
                driver.findElement(By.xpath(String.format(labelProductPrice, 6))).isDisplayed());
    }

    public Products clickProductImage(int index){

        driver.findElement(By.xpath(String.format(buttonProductImage, index))).click();
        return this;
    }

    public Products clickProductTitle(int index){

        driver.findElement(By.xpath(String.format(buttonProductTitle, index))).click();
        return this;
    }

    public Products clickAddToCart(int index){

        driver.findElement(By.xpath(String.format(buttonProductAddToCart, index))).click();
        return this;
    }

    public Products clickRemoveFromCart(int index){

        driver.findElement(By.xpath(String.format(buttonProductRemoveFromCart, index))).click();
        return this;
    }

    public String getProductDescription(int index){

        return driver.findElement(By.xpath(String.format(labelProductDescription, index))).getText(); //todo    confirm it works
    }

    public String getProductPrice(int index){

        String price = driver.findElement(By.xpath(String.format(labelProductPrice, index))).getText(); //todo  confirm it works
        return price.substring(1);
    }

}