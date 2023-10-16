package saucedemo.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BasePageObject {

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePageObject.driver = driver;
    }

    public static String randomAlphaNumeric(int length){

        return RandomStringUtils.random(length, true, true);
    }

}