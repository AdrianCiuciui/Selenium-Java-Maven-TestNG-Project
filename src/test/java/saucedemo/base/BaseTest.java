package saucedemo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.IntStream;

public class BaseTest{

    public WebDriver driver;
    private static final Properties PROPERTIES = new Properties();
    public static List<Item> productsOrdered = new ArrayList<>();
    protected static Integer[] randomNumbers;
    protected static int randomNumbersIndex = 0;

    @BeforeSuite
    public void readPropertiesFile() {
    try {
        FileInputStream input = new FileInputStream("src/test/java/saucedemo/base/resourcesSaucedemo.properties");
        PROPERTIES.load(input);
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(PROPERTIES.getProperty("url.base"));
        BasePageObject.setDriver(driver);
        waitImplicit(1);
        setUpRandomNumbersArray();
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

    public static int getTotalNumberOfDisplayedProducts(){

        String count = PROPERTIES.getProperty("products.count");
        return Integer.parseInt(count);
    }

    /**
     * @return a random unique value
     */
    public static int randomNumber0ToTotalAvailableProducts(){

        if (randomNumbersIndex >= getTotalNumberOfDisplayedProducts()) {
            System.out.println("All random numbers have been used");
            return -1;
        }
        else {
            return randomNumbers[randomNumbersIndex++];
        }
    }

    /**
     * This method prepares a unique and random array at each test run.
     * It will return -1 after the max number of entries.
     */
    private void setUpRandomNumbersArray(){

        randomNumbers = new Integer[getTotalNumberOfDisplayedProducts()];
        IntStream.range(0, getTotalNumberOfDisplayedProducts()).forEach(i -> randomNumbers[i] = i);
        List<Integer> intList = Arrays.asList(randomNumbers);
        Collections.shuffle(intList);
        intList.toArray(randomNumbers);
        System.out.println("[DEBUG] The current random array is: " + Arrays.toString(randomNumbers));
    }

    public static void waitImplicit(long seconds){

        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @AfterMethod
    public void tearDown() {

        randomNumbersIndex = 0;
        waitImplicit(1);
        driver.quit();
    }

}