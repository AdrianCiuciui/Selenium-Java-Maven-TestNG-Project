package saucedemo.base;

import org.apache.commons.lang3.RandomStringUtils;
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

}