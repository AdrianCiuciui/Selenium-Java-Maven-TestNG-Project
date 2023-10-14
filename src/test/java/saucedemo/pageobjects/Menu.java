package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Menu extends BasePageObject {

    private final By buttonProducts = xpath("//a[@id='inventory_sidebar_link']");
    private final By buttonAbout = xpath("//a[@id='about_sidebar_link']");
    private final By buttonLogout = xpath("//a[@id='logout_sidebar_link']");
    private final By buttonResetAppState = xpath("//a[@id='reset_sidebar_link']");
    private final By buttonCloseMenu = xpath("//button[@id='react-burger-cross-btn']");
    private final By menuBar = xpath("//div[@class='bm-menu']");

    public Menu(WebDriver driver) {
        super(driver);
    }


    public boolean isMenuDisplayed(){

        return driver.findElement(menuBar).isDisplayed();
    }

    public Menu clickOnProductsOption(){

        driver.findElement(buttonProducts).click();
        return this;
    }

    public Menu clickOnAboutOption(){

        driver.findElement(buttonAbout).click();
        return this;
    }

    public Menu clickOnLogoutOption(){

        driver.findElement(buttonLogout).click();
        return this;
    }

    public Menu clickOnResetAppState(){

        driver.findElement(buttonResetAppState).click();
        return this;
    }

    public Menu clickOnCloseMenu(){

        driver.findElement(buttonCloseMenu).click();
        return this;
    }

}