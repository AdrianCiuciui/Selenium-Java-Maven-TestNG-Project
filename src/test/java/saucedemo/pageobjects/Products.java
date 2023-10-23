package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Products extends BasePageObject {

    private final String buttonProductImage = "//*[@class='inventory_item_img']//*[@id='item_%d_img_link']";
    private final String buttonProductTitle = "//*[@class='inventory_item_label']//*[@id='item_%d_title_link']";
    private final String labelProductDescription = "//div[@class='inventory_item_label']//a[@id='item_%d_title_link']/following-sibling::div[@class='inventory_item_desc']";
    private final String labelProductPrice = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    private final String buttonProductAddToCart = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[contains(@class,'btn_primary')]";
    private final String buttonProductRemoveFromCart = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[contains(@class,'btn_secondary')]";


    public void checkPageIsDisplayed(){

        assertThat(driver.findElement(By.xpath(String.format(buttonProductImage, 0))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(buttonProductTitle, 1))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(buttonProductAddToCart, 2))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(labelProductDescription, 3))).isDisplayed(), is(true));
        assertThat(driver.findElement(By.xpath(String.format(labelProductPrice, 4))).isDisplayed(), is(true));
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
        return driver.findElement(By.xpath(String.format(labelProductDescription, index))).getText();
    }

    public String getProductPrice(int index){
        String price = driver.findElement(By.xpath(String.format(labelProductPrice, index))).getText();
        return price.substring(1);
    }

    public String getProductTitle(int index) {

        return driver.findElement(By.xpath(String.format(buttonProductTitle, index))).getText();
    }

    public boolean isProductInCart(int index){
//todo      add check so that remove from cart is also considered
        return !driver.findElement(By.xpath(String.format(buttonProductAddToCart, index))).isDisplayed();
    }




}