package saucedemo.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public static String randomAlphaNumeric(int length){

        return RandomStringUtils.random(length, true, true);
    }

}