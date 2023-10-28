package saucedemo.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public static void setDriver(WebDriver driver){

        BasePageObject.driver = driver;
        Duration timeoutDuration = Duration.ofSeconds(12);
        driverWait = new WebDriverWait(driver, timeoutDuration);
    }

    public static String randomAlphaNumeric(int length){

        return RandomStringUtils.random(length, true, true);
    }

    public void waitExplicit(WebElement webElement){

        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitImplicit(long seconds){
        try {
            driver.wait(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementDisplayed(By locator){

            return driver.findElements(locator).size() != 0;
    }

    public void inputValues(By element, String input){

        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(input);
    }

    public void clickOnButton(By element){

        driver.findElement(element).click();
    }

    public String getTextFromField(By element){

        return driver.findElement(element).getText();
    }

}