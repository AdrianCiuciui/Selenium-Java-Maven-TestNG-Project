package saucedemo.steps;

import saucedemo.base.BasePageObject;
import saucedemo.pageobjects.Login;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static saucedemo.base.BaseTest.getPassword;
import static saucedemo.base.BaseTest.getURLBase;
import static saucedemo.base.BaseTest.getURLInventory;
import static saucedemo.base.BaseTest.getUsernameLocked;
import static saucedemo.base.BaseTest.getUsernameNotRegistered;
import static saucedemo.base.BaseTest.getUsernameRegular;

public class LoginSteps extends BasePageObject{

    private final Login login;

    public LoginSteps(){
        login = new Login();
    }


    public void loginWithUsername(String username, String password){

        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL, containsString(getURLBase()));
        login.checkAllPageElementsAreDisplayed();
        login.inputUsername(username);
        login.inputPassword(password);
        login.clickLoginButton();
    }

    public void loginWithUsernameRegular(){
        login.inputUsername(getUsernameRegular());
        login.inputPassword(getPassword());
        login.clickLoginButton();
    }

    public void checkPageAfterLogin(String username){

        String currentURL = driver.getCurrentUrl();
        if (username.equals(getUsernameLocked())) {
            assertThat(currentURL, containsString(getURLBase()));
        } else if (username.equals(getUsernameNotRegistered())) {
            login.checkErrorMessageAndRedInputFieldsAreDisplayed();
            login.clickToCloseErrorMessage();
            login.checkAllPageElementsAreDisplayed();
        } else {
            assertThat(currentURL, containsString(getURLInventory()));
        }
    }

    public void checkErrorIndicatorsAreDisplayedAndThatTheyCanBeClearedAway(){

        login.checkErrorMessageAndRedInputFieldsAreDisplayed();
        login.clickToCloseErrorMessage();
        login.checkAllPageElementsAreDisplayed();
    }

}