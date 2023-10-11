package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Login;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static saucedemo.base.BaseTest.getURLBase;
import static saucedemo.base.BaseTest.getURLInventory;
import static saucedemo.base.BaseTest.getUsernameLocked;
import static saucedemo.base.BaseTest.getUsernameNotRegistered;

public class LoginSteps {


    protected WebDriver driver;
    private final Login login;

    public LoginSteps(WebDriver driver){

        login = new Login(driver);
        this.driver = driver;
    }

    public LoginSteps loginWithUsername(String username, String password){

        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL, containsString(getURLBase()));
        assertThat(login.isPageElementsDisplayed(), is(true));
        login.inputUsername(username).
                inputPassword(password).
                clickLoginButton();
        return this;
    }

    public LoginSteps checkPageAfterLogin(String username){

        String currentURL = driver.getCurrentUrl();
        if (username.equals(getUsernameLocked())) {
            assertThat(currentURL, containsString(getURLBase()));
        } else if (username.equals(getUsernameNotRegistered())) {
            assertThat(login.isPageElementesWithErrorMessageDisplayed(), is(true));
            login.clickToCloseErrorMessage();
            assertThat(login.isPageElementsDisplayed(), is(true));
        } else {
            assertThat(currentURL, containsString(getURLInventory()));
        }
        return this;
    }

    public LoginSteps checkErrorIndicatorsOnLoginAndTheirClear(){

        assertThat(login.isPageElementesWithErrorMessageDisplayed(), is(true));
        login.clickToCloseErrorMessage();
        assertThat(login.isPageElementsDisplayed(), is(true));
        return this;
    }
}