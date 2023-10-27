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

        assertThat(isElementDisplayed(pageTitle), is(true)) ;
    }

    public void clickMenuButton(){

        clickOnButton(buttonMenu);
    }

    public void clickCartButton(){

        clickOnButton(buttonCart);
    }

    public void clickFilterButton(){

        clickOnButton(buttonFilter);
    }

    public void clickFilterOptionAZ(){

        clickOnButton(filterOptionsAZ);
    }

    public void clickFilterOptionZA(){

        clickOnButton(filterOptionsZA);
    }

    public void clickFilterOptionLowToHigh(){

        clickOnButton(filterOptionsLowHigh);
    }

    public void clickFilterOptionHighToLow(){

        clickOnButton(filterOptionsHighLow);
    }

    public int getCartBadgeValue(){

        String returnedValue = driver.findElement(cartBadge).getText();
        return Integer.parseInt(returnedValue);
    }

    public boolean isBadgeDisplayed(){

        return isElementDisplayed(cartBadge);
    }

}