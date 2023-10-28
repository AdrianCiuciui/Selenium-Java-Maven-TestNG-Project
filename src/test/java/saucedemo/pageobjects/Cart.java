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
        clickOnButton(buttonCheckout);
    }

    public void clickContinueShoppingButton(){
        clickOnButton(buttonContinueShopping);
    }

    /**
     * @param index Start from 0, but this particular page starts from 1
     */
    public void clickProductRemoveButton(int index){
        driver.findElement(By.xpath(String.format(buttonProductRemove, index + 1))).click();
    }

    /**
     * @param index Start from 0, but this particular page starts from 1
     */
    public void clickProductTitle(int index){
        driver.findElement(By.xpath(String.format(buttonProductTitle, index + 1))).click();
    }

    /**
     * @param index Start from 0, but this particular page starts from 1
     * @return The description as String
     */
    public String getProductDescription(int index){

        return driver.findElement(By.xpath(String.format(labelDescription, index + 1))).getText();
    }

    /**
     * @param index Start from 0, but this particular page starts from 1
     * @return The price, without the leading currency, as string
     */
    public String getProductPrice(int index){

        return driver.findElement(By.xpath(String.format(labelPrice, index + 1))).getText().substring(1);
    }

}