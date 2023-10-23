package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.steps.LoginSteps;


public class LoginTests extends BaseTest{


    private LoginSteps loginSteps;


    @Override
    @BeforeMethod()
    public void setup(){
        super.setup();
        loginSteps = new LoginSteps();
    }

    @DataProvider
    public static Object[][] userType(){

        return new Object[][] {
                {getUsernameRegular()},
                {getUsernameLocked()},
                {getUsernameProblem()},
                {getUsernamePerformanceIssues()},
                {getUsernameError()}
        };
    }

    /**
     * The test logs in with all available test users and checks the next page
     *
     * @param username taken from the Dataprovider
     */
    @Test(priority = 1, dataProvider = "userType")
    public void loginWithEachUser(String username){

        loginSteps.loginWithUsername(username, getPassword());
        loginSteps.checkPageAfterLogin(username);
    }


    @DataProvider
    public static Object[][] invalidCredentials(){

        return new Object[][]{
                {getUsernameNotRegistered(), getPassword() + "aa"},
                {getUsernameNotRegistered(), getPassword()},
                {getUsernameRegular(), getPassword() + "aa"}
        };
    }

    /**
     * This test covers the errors cases on the login form.
     */
    @Test(priority = 5, dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String username, String password){

        loginSteps.loginWithUsername(username, password);
        loginSteps.checkErrorIndicatorsAreDisplayedAndThatTheyCanBeClearedAway();
    }

}