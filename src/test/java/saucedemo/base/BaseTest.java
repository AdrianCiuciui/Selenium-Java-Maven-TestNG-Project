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
import java.util.Random;

public class BaseTest {

    public WebDriver driver;
    private static final Properties PROPERTIES = new Properties();
    protected static boolean[] isProductInCart = new boolean[6];

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
        driver.manage().window().maximize();
        driver.navigate().to(PROPERTIES.getProperty("url.base"));
        waitUntilTimeIsPassed(1);
    }

    public static String getUsernameRegular(){

        return PROPERTIES.getProperty("username.standard");
    }

    public static String getUsernameLocked(){

        return PROPERTIES.getProperty("username.locked");
    }

    public static String getUsernameProblem(){

        return PROPERTIES.getProperty("username.problem");
    }

    public static String getUsernamePerformanceIssues(){

        return PROPERTIES.getProperty("username.performance");
    }

    public static String getUsernameNotRegistered(){

        return PROPERTIES.getProperty("username.unavailable");
    }

    public static String getUsernameError(){

        return PROPERTIES.getProperty("username.error");
    }

    public static String getPassword(){

        return PROPERTIES.getProperty("password");
    }

    public static String getURLBase(){

        return PROPERTIES.getProperty("url.base");
    }

    public static String getURLCart(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.cart"));
    }

    public static String getURLInventory(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.inventory"));
    }

    public static String getURLCheckoutStepOne(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.checkout.one"));
    }

    public static String getURLCheckoutStepTwo(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("url.checkout.two"));
    }

    public static String getURLCheckoutSuccess(){

        return (PROPERTIES.getProperty("url.base") + PROPERTIES.getProperty("/checkout-complete.html"));
    }

    public static int randomValue(){

        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void changeProductsArrayBooleanStatus(){


    }

    @AfterMethod
    public void tearDown() {

        waitUntilTimeIsPassed(2);
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