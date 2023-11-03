package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Products extends BasePageObject {//todo    \\..//

    private final String buttonProductImage = "//*[@class='inventory_item_img']//*[@id='item_%d_img_link']";
    private final String buttonProductTitle = "//*[@class='inventory_item_label']//*[@id='item_%d_title_link']";
    private final String labelProductDescription = "//div[@class='inventory_item_label']//a[@id='item_%d_title_link']/following-sibling::div[@class='inventory_item_desc']";
    private final String labelProductPrice = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    private final String buttonProductAddToCart = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[contains(@class,'btn_primary')]";
    private final String buttonProductRemoveFromCart = "//*[@id='item_%d_title_link']/ancestor::*[@class='inventory_item_description']//*[contains(@class,'btn_secondary')]";


    public void checkPageIsDisplayed(){

        int index = 0;
        assertThat(isElementDisplayed(By.xpath(String.format(buttonProductImage, index++))), is(true));
        assertThat(isElementDisplayed(By.xpath(String.format(buttonProductTitle, index++))), is(true));
        assertThat(isElementDisplayed(By.xpath(String.format(buttonProductAddToCart, index++))), is(true));
        assertThat(isElementDisplayed(By.xpath(String.format(labelProductDescription, index++))), is(true));
        assertThat(isElementDisplayed(By.xpath(String.format(labelProductPrice, index))), is(true));
    }

    public void clickProductImage(int index){
        clickOnButton(By.xpath(String.format(buttonProductImage, index)));
    }

    public void clickProductTitle(int index){
        clickOnButton(By.xpath(String.format(buttonProductTitle, index)));
    }

    public void clickAddToCart(int index){
        clickOnButton(By.xpath(String.format(buttonProductAddToCart, index)));
    }

    public void clickRemoveFromCart(int index){
        clickOnButton(By.xpath(String.format(buttonProductRemoveFromCart, index)));
    }

    public String getProductDescription(int index){
        return getTextFromField(By.xpath(String.format(labelProductDescription, index)));
    }

    public String getProductPrice(int index){
        String price = getTextFromField(By.xpath(String.format(labelProductPrice, index)));
        return price.substring(1);
    }

    public String getProductTitle(int index) {

        return getTextFromField(By.xpath(String.format(buttonProductTitle, index)));
    }

    public boolean isProductInCart(int index){
//todo      add check so that remove from cart is also considered
        return !driver.findElement(By.xpath(String.format(buttonProductAddToCart, index))).isDisplayed();
    }

}