package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Menu extends BasePageObject {

    private final By buttonProducts = id("inventory_sidebar_link");
    private final By buttonAbout = id("about_sidebar_link");
    private final By buttonLogout = id("logout_sidebar_link");
    private final By buttonResetAppState = id("reset_sidebar_link");
    private final By buttonCloseMenu = id("react-burger-cross-btn");
    private final By menuBar = xpath("//div[@class='bm-menu']");

    public void checkMenuIsDisplayed(){

        assertThat("The menu bad is not displayed",
                isElementDisplayed(menuBar), is(true));
    }

    public void clickOnProductsOption(){
        clickOnButton(buttonProducts);
    }

    public void clickOnAboutOption(){
        clickOnButton(buttonAbout);
    }

    public void clickOnLogoutOption(){

        WebElement logoutButton = driver.findElement(buttonLogout);
        waitExplicit(logoutButton);
        logoutButton.click();
    }

    public void clickOnResetAppState(){
        clickOnButton(buttonResetAppState);
    }

    public void clickOnCloseMenu(){
        clickOnButton(buttonCloseMenu);
    }

}