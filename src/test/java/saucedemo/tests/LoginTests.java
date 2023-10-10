package saucedemo.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pageobjects.Login;

public class LoginTests extends BaseTest {


    private Login login;


    @Override
    @BeforeMethod()
    public void setup(){
        super.setup();
        login = new Login(driver);
    }

    @Test
    public void loginWithRegularUser(){

        login.inputUsername(getUsernameRegular()).
                inputPassword(getPassword()).
                clickLoginButton();



    }


}