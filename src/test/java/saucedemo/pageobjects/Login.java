package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

public class Login extends BasePageObject {


    private By inputFieldUsername = By.xpath("//input[@id='user-name']");
    private By inputFieldPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//input[@id='login-button']");
    private By errorAtCredentials = By.xpath("//div[@class='error-message-container error']//h3[@data-test='error']");

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







}