package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.steps.LoginSteps;


public class LoginTests extends BaseTest {


    private LoginSteps loginSteps;


    @Override
    @BeforeMethod()
    public void setup(){
        super.setup();
        loginSteps = new LoginSteps(driver);
    }

    @DataProvider
    public static Object[][] userType(){

        return new Object[][] {
                {getUsernameLocked()},
                {getUsernameProblem()},
                {getUsernamePerformanceIssues()},
                {getUsernameError()}
        };
    }

    @Test(priority = 1)
    public void loginWithRegularUser(){

        String username = getUsernameRegular();
        loginSteps.
                loginWithUsername(username, getPassword()).
                checkPageAfterLogin(username);
    }

    @Test(priority = 5, dataProvider = "userType")
    public void loginWithNonRegularUser(String username){

        loginSteps.
                loginWithUsername(username, getPassword()).
                checkPageAfterLogin(username);
    }

    @Test(priority = 10)
    public void loginWithInvalidCredentials(){

        String usernameNotRegistered = getUsernameNotRegistered();
        String usernameExisting = getUsernameRegular();
        String passwordNotOk = getPassword() + "aa";
        String passwordOk = getPassword();

        //todo   fa cu dataprovider
        loginSteps.
                loginWithUsername(usernameNotRegistered, passwordNotOk).
                checkErrorIndicatorsOnLoginAndTheirClear().
                loginWithUsername(usernameNotRegistered, passwordOk).
                checkErrorIndicatorsOnLoginAndTheirClear().
                loginWithUsername(usernameExisting, passwordNotOk).
                checkErrorIndicatorsOnLoginAndTheirClear();
    }
}