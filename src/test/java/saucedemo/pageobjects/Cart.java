package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Cart extends BasePageObject {

    private final By buttonCheckout = xpath("//button[@id='checkout']");
    private final By buttonContinueShopping = xpath("//button[@id='continue-shopping']");
    private final String buttonProductRemove = "(//*[contains(@id,'remove')])[%d]";
    private final String buttonProductTitle = "(//*[@class='inventory_item_name'])[%d]";
    private final String labelDescription = "(//*[@class='inventory_item_desc'])[%d]";
    private final String labelPrice = "(//*[@class='inventory_item_price'])[%d]";

    public Cart clickCheckoutButton(){

        driver.findElement(buttonCheckout).click();
        return this;
    }

    public Cart clickContinueShoppingButton(){

        driver.findElement(buttonContinueShopping).click();
        return this;
    }

    public Cart clickProductRemoveButton(int index){

        driver.findElement(By.xpath(String.format(buttonProductRemove, index))).click();
        return this;
    }

    public Cart clickProductTitle(int index){

        driver.findElement(By.xpath(String.format(buttonProductTitle, index))).click();
        return this;
    }

    public String getProductDescription(int index){

        return driver.findElement(By.xpath(String.format(labelDescription, index))).getText();
    }

    public String getProductPrice(int index){

        return driver.findElement(By.xpath(String.format(labelPrice, index))).getText().substring(1);
    }

}