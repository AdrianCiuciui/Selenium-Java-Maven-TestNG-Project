package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Header extends BasePageObject {

    private By pageTitle = xpath("//*[@class='title']");
    private By buttonMenu = xpath("//*[@id='react-burger-menu-btn']");
    private By buttonCart = xpath("//*[@id='shopping_cart_container']");
    private By buttonFilter = xpath("//*[@class='select_container']");
    private By cartBadge = xpath("//*[@class='shopping_cart_badge']");
    private By filterOptionsAZ = xpath("//option[@value='az']");
    private By filterOptionsZA = xpath("//option[@value='za']");
    private By filterOptionsLowHigh = xpath("//option[@value='lohi']");
    private By filterOptionsHighLow = xpath("//option[@value='hilo']");





    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(){

        return driver.findElement(pageTitle).isDisplayed();
    }

    public Header clickMenuButton(){

        driver.findElement(buttonMenu).click();
        return this;
    }

    public Header clickCartButton(){

        driver.findElement(buttonCart).click();
        return this;
    }

    public Header clickFilterButton(){

        driver.findElement(buttonFilter).click();
        return this;
    }

    public Header clickFilterOptionAZ(){

        driver.findElement(filterOptionsAZ).click();
        return this;
    }

    public Header clickFilterOptionZA(){

        driver.findElement(filterOptionsZA).click();
        return this;
    }

    public Header clickFilterOptionLowToHigh(){

        driver.findElement(filterOptionsLowHigh).click();
        return this;
    }

    public Header clickFilterOptionHighToLow(){

        driver.findElement(filterOptionsHighLow).click();
        return this;
    }

    public String getCartBadgeValue(){

        return driver.findElement(cartBadge).getText(); //todo daca nu merge, incearca cu get attribute
    }

}
