package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.base.BasePageObject;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CheckoutStepOne extends BasePageObject {

    private final By buttonCancel = xpath("//button[@id='cancel']");
    private final By buttonContinue = xpath("//button[@id='continue']");
    private final By buttonErrorCloseMessage = xpath("//button[@class='error-button']");
    private final By inputFirstName = xpath("//input[@id='first-name']");
    private final By inputLastName = xpath("//input[@id='last-name']");
    private final By inputPostalCode = xpath("//input[@id='postal-code']");
    private final By errorMessage = xpath("//div[@class='error-message-container error']");
    private final By errorIconInInputField_NotUnique = xpath("//div[@class='form_group']//*[@data-prefix='fas']");
    private final By errorInputFields_NotUnique = xpath("//input[@class='input_error form_input error']");
    private final int NO_OF_INPUT_FIELDS = 3;


    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }


    public CheckoutStepOne clickCancelButton(){

        driver.findElement(buttonCancel).click();
        return this;
    }

    public CheckoutStepOne clickContinueButton(){

        driver.findElement(buttonContinue).click();
        return this;
    }

    public CheckoutStepOne clickCloseErrorMessageButton(){

        driver.findElement(buttonErrorCloseMessage).click();
        return this;
    }

    public CheckoutStepOne inputFirstName(String input){

        driver.findElement(inputFirstName).sendKeys(input);
        return this;
    }

    public CheckoutStepOne inputLastName(String input){

        driver.findElement(inputLastName).sendKeys(input);
        return this;
    }

    public CheckoutStepOne inputPostalCode(String input){

        driver.findElement(inputPostalCode).sendKeys(input);
        return this;
    }

    public boolean isErrorMessageDisplayed(){

        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isAllErrorIconsDisplayedInInputFields(){

        return checkEachInputFieldHasError(errorIconInInputField_NotUnique);
    }

    public boolean isAllInputFieldsTurnedRed(){

        return checkEachInputFieldHasError(errorInputFields_NotUnique);
    }

    private boolean checkEachInputFieldHasError(By locator){

        List<WebElement> elements = driver.findElements(locator);
        int occurrencesCount = elements.size();
        return (occurrencesCount == NO_OF_INPUT_FIELDS);
    }

}