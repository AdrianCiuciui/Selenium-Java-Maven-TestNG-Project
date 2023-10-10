package saucedemo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    private final Properties PROPERTIES = new Properties();

    @BeforeSuite
    public  void readPropertiesFile() {
    try {
        FileInputStream input = new FileInputStream("src/test/java/saucedemo/base/resourcesSaucedemo.properties");
        PROPERTIES.load(input);
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(PROPERTIES.getProperty("url.base"));
        waitUntilTimeIsPassed(2);
    }

    public String getUsernameRegular(){

        return PROPERTIES.getProperty("username.standard");
    }

    public String getUsernameLocked(){

        return PROPERTIES.getProperty("username.locked");
    }

    public String getUsernameProblem(){

        return PROPERTIES.getProperty("username.problem");
    }

    public String getUsernamePerformanceIssues(){

        return PROPERTIES.getProperty("username.performance");
    }

    public String getPassword(){

        return PROPERTIES.getProperty("password");
    }

    public String getURLBase(){

        return PROPERTIES.getProperty("url.base");
    }

    public String getURLCart(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.cart"));
    }

    public String getURLInventory(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.inventory"));
    }

    public String getURLCheckoutStepOne(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.checkout.one"));
    }

    public String getURLCheckoutStepTwo(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.checkout.two"));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    public void waitUntilTimeIsPassed(long seconds){

        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }






}