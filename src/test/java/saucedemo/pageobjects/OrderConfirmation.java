package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

public class OrderConfirmation extends BasePageObject {

    private final By labelSuccessIcon = className("pony_express");
    private final By labelSuccessMessageHeader = className("complete-header");
    private final By labelSuccessMessageDescription = className("complete-text");
    private final By buttonBackHome = id("back-to-products");

    public void clickBackHomeButton(){
        clickOnButton(buttonBackHome);
    }

    public void checkSuccessImageIsDisplayed(){
        assertThat("Success image is not displayed",
                isElementDisplayed(labelSuccessIcon), is(true) );
    }

    public void checkMessageHeaderIsDisplayed(){
        assertThat("Success message header is not displayed",
                isElementDisplayed(labelSuccessMessageHeader), is(true));
    }

    public void checkMessageDescriptionIsDisplayed(){
        assertThat("Success message description is not displayed",
                isElementDisplayed(labelSuccessMessageDescription), is(true));
    }

}