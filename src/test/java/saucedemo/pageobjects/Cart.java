package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Cart extends BasePageObject {

    private final By buttonCheckout = xpath("//button[@id='checkout']");
    private final By buttonContinueShopping = xpath("//button[@id='continue-shopping']");
    private final String buttonProductRemove = "(//*[contains(@id,'remove')])[%d]";
    private final String buttonProductTitle = "(//*[@class='inventory_item_name'])[%d]";
    private final String labelDescription = "(//*[@class='inventory_item_desc'])[%d]";
    private final String labelPrice = "(//*[@class='inventory_item_price'])[%d]";

    public void clickCheckoutButton(){
        driver.findElement(buttonCheckout).click();
    }

    public void clickContinueShoppingButton(){
        driver.findElement(buttonContinueShopping).click();
    }

    public void clickProductRemoveButton(int index){
        driver.findElement(By.xpath(String.format(buttonProductRemove, index))).click();
    }

    public void clickProductTitle(int index){
        driver.findElement(By.xpath(String.format(buttonProductTitle, index))).click();
    }

    public String getProductDescription(int index){

        return driver.findElement(By.xpath(String.format(labelDescription, index))).getText();
    }

    public String getProductPrice(int index){

        return driver.findElement(By.xpath(String.format(labelPrice, index))).getText().substring(1);
    }

}