package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.openqa.selenium.By.xpath;

public class Login extends BasePageObject {
    private final By logo = xpath("//div[@class='login_logo']");
    private final By loginCredentials = xpath("//div[@class='login_credentials_wrap-inner']");
    private final By inputFieldUsername = xpath("//input[@id='user-name']");
    private final By inputFieldPassword = xpath("//input[@id='password']");
    private final By buttonLogin = xpath("//input[@id='login-button']");
    private final By errorTextMessage = xpath("//div[@class='error-message-container error']//h3[@data-test='error']");
    private final By errorIconInInputField = xpath("//div[@class='login-box']//*[@data-icon='times-circle']");
    private final By getErrorAtCredentialsButton = xpath("//h3[@data-test='error']//button");
    private final By errorTextMessageIsHidden = xpath("//div[@class='error-message-container']");

    public void inputUsername(String username) {
        driver.findElement(inputFieldUsername).clear();
        driver.findElement(inputFieldUsername).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(inputFieldPassword).clear();
        driver.findElement(inputFieldPassword).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(buttonLogin).click();
    }

    public void checkAllPageElementsAreDisplayed(){

        assertThat("Logo not displayed", driver.findElement(logo).isDisplayed(), is(true));
        assertThat("Login credentials not displayed", driver.findElement(loginCredentials).isDisplayed(), is(true));
        assertThat("Error text message is not hidden", driver.findElement(errorTextMessageIsHidden).isDisplayed(), is(true));
    }

    public void checkErrorMessageAndRedInputFieldsAreDisplayed(){

        assertThat(driver.findElement(errorTextMessage).isDisplayed(), is(true));
        assertThat(driver.findElement(errorIconInInputField).isDisplayed(), is(true));
    }

    public void clickToCloseErrorMessage(){
        driver.findElement(getErrorAtCredentialsButton).click();
    }

}