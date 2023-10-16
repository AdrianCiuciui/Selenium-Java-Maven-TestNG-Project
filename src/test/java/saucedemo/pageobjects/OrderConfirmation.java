package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class OrderConfirmation extends BasePageObject {

    private final By labelSuccessIcon = xpath("//*[@class='pony_express']");
    private final By labelSuccessMessageHeader = xpath("//*[@class='complete-header']");
    private final By labelSuccessMessageDescription = xpath("//*[@class='complete-text']");
    private final By buttonBackHome = xpath("//button[@id='back-to-products']");

    public void clickBackHomeButton(){
        driver.findElement(buttonBackHome).click();
    }

    public boolean isSuccessImageDisplayed(){
        return driver.findElement(labelSuccessIcon).isDisplayed();
    }

    public boolean isMessageHeaderDisplayed(){
        return driver.findElement(labelSuccessMessageHeader).isDisplayed();
    }

    public boolean isMessageDescriptionDisplayed(){
        return driver.findElement(labelSuccessMessageDescription).isDisplayed();
    }

}