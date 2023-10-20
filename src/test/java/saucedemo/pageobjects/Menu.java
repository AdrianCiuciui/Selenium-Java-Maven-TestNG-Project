package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.xpath;

public class Menu extends BasePageObject {

    private final By buttonProducts = xpath("//a[@id='inventory_sidebar_link']");
    private final By buttonAbout = xpath("//a[@id='about_sidebar_link']");
    private final By buttonLogout = xpath("//a[@id='logout_sidebar_link']");
    private final By buttonResetAppState = xpath("//a[@id='reset_sidebar_link']");
    private final By buttonCloseMenu = xpath("//button[@id='react-burger-cross-btn']");
    private final By menuBar = xpath("//div[@class='bm-menu']");

    public void checkMenuIsDisplayed(){

        assertThat(driver.findElement(menuBar).isDisplayed(), is(true));
    }

    public void clickOnProductsOption(){
        driver.findElement(buttonProducts).click();
    }

    public void clickOnAboutOption(){
        driver.findElement(buttonAbout).click();
    }

    public void clickOnLogoutOption(){
        driver.findElement(buttonLogout).click();
    }

    public void clickOnResetAppState(){
        driver.findElement(buttonResetAppState).click();
    }

    public void clickOnCloseMenu(){
        driver.findElement(buttonCloseMenu).click();
    }

}