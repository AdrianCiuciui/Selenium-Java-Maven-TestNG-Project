package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Product extends BasePageObject {

    private final By buttonAddToCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_primary')]");
    private final By buttonRemoveFromCart = xpath("//*[@class='inventory_details_desc_container']//*[contains(@class,'btn_secondary')]");
    private final By buttonBackToProducts = id("back-to-products");
    private final By labelProductName = xpath("//div[@class='inventory_details_name large_size']");
    private final By labelProductDescription = xpath("//div[@class='inventory_details_desc large_size']");
    private final By labelProductPrice = className("inventory_details_price");
    private final By productImage = className("inventory_details_img");

    public void clickBackToProducts(){
        clickOnButton(buttonBackToProducts);
    }

    public void clickAddToCart(){
        clickOnButton(buttonAddToCart);
    }

    public void clickRemoveFromCart(){
        clickOnButton(buttonRemoveFromCart);
    }

    public String getProductName(){
        return getTextFromField(labelProductName);
    }

    public String getProductDescription(){
        return getTextFromField(labelProductDescription);
    }

    public String getProductPrice(){
        return getTextFromField(labelProductPrice);
    }

    public boolean isProductTitleDisplayed(){
        return isElementDisplayed(labelProductName);
    }

    public boolean isDescriptionDisplayed(){
        return isElementDisplayed(labelProductDescription);
    }

    public boolean isPriceDisplayed(){
        return isElementDisplayed(labelProductPrice);
    }

    public boolean isImageDisplayed(){
        return isElementDisplayed(productImage);
    }

    public boolean isReturnButtonDisplayed(){
        return isElementDisplayed(buttonBackToProducts);
    }

    public boolean isAddToCartButtonDisplayed(){
        return isElementDisplayed(buttonAddToCart);
    }

    public boolean isRemoveFromCartButtonDisplayed(){
        return isElementDisplayed(buttonRemoveFromCart);
    }

}