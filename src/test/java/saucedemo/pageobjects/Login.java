package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Login extends BasePageObject {
    private final By logo = className("login_logo");
    private final By loginCredentials = className("login_credentials_wrap-inner");
    private final By inputFieldUsername = id("user-name");
    private final By inputFieldPassword = id("password");
    private final By buttonLogin = id("login-button");
    private final By errorTextMessage = xpath("//div[@class='error-message-container error']//h3[@data-test='error']");
    private final By errorIconInInputField = xpath("//div[@class='login-box']//*[@data-icon='times-circle']");
    private final By getErrorAtCredentialsButton = xpath("//h3[@data-test='error']//button");
    private final By errorTextMessageIsHidden = xpath("//div[@class='error-message-container']");

    public void inputUsername(String username) {
        inputValues(inputFieldUsername, username);
    }

    public void inputPassword(String password){
        inputValues(inputFieldPassword, password);
    }

    public void clickLoginButton(){
        clickOnButton(buttonLogin);
    }

    public void checkAllPageElementsAreDisplayed(){

        assertThat("Logo not displayed", isElementDisplayed(logo), is(true));
        assertThat("Login credentials not displayed",
                isElementDisplayed(loginCredentials), is(true));
        assertThat("Error text message is not hidden",
                isElementDisplayed(errorTextMessageIsHidden), is(true));
    }

    public void checkErrorMessageAndRedInputFieldsAreDisplayed(){

        assertThat("The error message is not displayed",
                isElementDisplayed(errorTextMessage), is(true));
        assertThat("The error icon inside the input field is not displayed",
                isElementDisplayed(errorIconInInputField), is(true));
    }

    public void clickToCloseErrorMessage(){
        clickOnButton(getErrorAtCredentialsButton);
    }

}