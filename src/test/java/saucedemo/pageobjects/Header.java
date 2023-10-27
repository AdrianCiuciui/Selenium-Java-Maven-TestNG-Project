package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Header extends BasePageObject {

    private final By pageTitle = xpath("//*[@class='title']");
    private final By buttonMenu = id("react-burger-menu-btn");
    private final By buttonCart = id("shopping_cart_container");
    private final By buttonFilter = className("select_container");
    private final By cartBadge = className("shopping_cart_badge");
    private final By filterOptionsAZ = xpath("//option[@value='az']");
    private final By filterOptionsZA = xpath("//option[@value='za']");
    private final By filterOptionsLowHigh = xpath("//option[@value='lohi']");
    private final By filterOptionsHighLow = xpath("//option[@value='hilo']");

    public void checkTitleIsDisplayed(){

        assertThat(driver.findElement(pageTitle).isDisplayed(), is(true)) ;
    }

    public void clickMenuButton(){

        driver.findElement(buttonMenu).click();
    }

    public void clickCartButton(){

        driver.findElement(buttonCart).click();
    }

    public void clickFilterButton(){

        driver.findElement(buttonFilter).click();
    }

    public void clickFilterOptionAZ(){

        driver.findElement(filterOptionsAZ).click();
    }

    public void clickFilterOptionZA(){

        driver.findElement(filterOptionsZA).click();
    }

    public void clickFilterOptionLowToHigh(){

        driver.findElement(filterOptionsLowHigh).click();
    }

    public void clickFilterOptionHighToLow(){

        driver.findElement(filterOptionsHighLow).click();
    }

    public int getCartBadgeValue(){

        String returnedValue = driver.findElement(cartBadge).getText();
        return Integer.parseInt(returnedValue);
    }

    public boolean isBadgeDisplayed(){

        return !isElementNotDisplayed(cartBadge);
    }

}