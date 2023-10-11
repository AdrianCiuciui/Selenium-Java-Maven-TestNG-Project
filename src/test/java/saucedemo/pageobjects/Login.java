package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Login extends BasePageObject {


    private By logo = xpath("//div[@class='login_logo']");
    private By loginCredentials = xpath("//div[@class='login_credentials_wrap-inner']");
    private By inputFieldUsername = xpath("//input[@id='user-name']");
    private By inputFieldPassword = xpath("//input[@id='password']");
    private By buttonLogin = xpath("//input[@id='login-button']");
    private By errorTextMessage = xpath("//div[@class='error-message-container error']//h3[@data-test='error']");
    private By errorIconInInputField = xpath("//div[@class='login-box']//*[@data-icon='times-circle']");
    private By getErrorAtCredentialsButton = xpath("//h3[@data-test='error']//button");
    private By errorTextMessageIsHidden = xpath("//div[@class='error-message-container']");


    public Login(WebDriver driver) {
        super(driver);
    }



    public Login inputUsername(String username) {

        driver.findElement(inputFieldUsername).clear();
        driver.findElement(inputFieldUsername).sendKeys(username);
        return this;
    }

    public Login inputPassword(String password){

        driver.findElement(inputFieldPassword).clear();
        driver.findElement(inputFieldPassword).sendKeys(password);
        return this;
    }

    public Login clickLoginButton(){

        driver.findElement(buttonLogin).click();
        return this;
    }

    public boolean isPageElementsDisplayed(){

        return (
            driver.findElement(logo).isDisplayed() &&
            driver.findElement(loginCredentials).isDisplayed() &&
            driver.findElement(errorTextMessageIsHidden).isDisplayed());
    }

    public boolean isPageElementesWithErrorMessageDisplayed(){
        return (
            driver.findElement(errorTextMessage).isDisplayed() &&
            driver.findElement(errorIconInInputField).isDisplayed());
    }

    public Login clickToCloseErrorMessage(){

        driver.findElement(getErrorAtCredentialsButton).click();
        return this;
    }







}