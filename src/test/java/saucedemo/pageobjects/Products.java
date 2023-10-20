package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Products extends BasePageObject {

    private final String buttonProductAllSection = "(//div[@class='inventory_item'])[%d]";
    private final String buttonProductImage = buttonProductAllSection + "//*[@class='inventory_item_img']//*[contains(@id,'item')]";
    private final String buttonProductTitle = buttonProductAllSection + "//*[@class='inventory_item_label']//*[contains(@id,'item')]";
    private final String buttonProductAddToCart = buttonProductAllSection + "//*[contains(@class,'btn_primary')]";
    private final String buttonProductRemoveFromCart = buttonProductAllSection + "//*[contains(@class,'btn_secondary')]";
    private final String labelProductDescription = buttonProductAllSection + "//*[@class='inventory_item_desc']";
    private final String labelProductPrice = buttonProductAllSection + "//*[@class='inventory_item_price']";


    public void checkPageIsDisplayed(){

        assertThat(driver.findElement(By.xpath(String.format(buttonProductAllSection, 1))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(buttonProductImage, 2))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(buttonProductTitle, 3))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(buttonProductAddToCart, 4))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(labelProductDescription, 5))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(labelProductPrice, 6))).isDisplayed(), is(true));
    }

    public void clickProductImage(int index){
        driver.findElement(By.xpath(String.format(buttonProductImage, index))).click();
    }

    public void clickProductTitle(int index){
        driver.findElement(By.xpath(String.format(buttonProductTitle, index))).click();
    }

    public void clickAddToCart(int index){
        driver.findElement(By.xpath(String.format(buttonProductAddToCart, index))).click();
    }

    public void clickRemoveFromCart(int index){
        driver.findElement(By.xpath(String.format(buttonProductRemoveFromCart, index))).click();
    }

    public String getProductDescription(int index){
        return driver.findElement(By.xpath(String.format(labelProductDescription, index))).getText(); //todo    confirm it works
    }

    public String getProductPrice(int index){
        String price = driver.findElement(By.xpath(String.format(labelProductPrice, index))).getText(); //todo  confirm it works
        return price.substring(1);
    }

}