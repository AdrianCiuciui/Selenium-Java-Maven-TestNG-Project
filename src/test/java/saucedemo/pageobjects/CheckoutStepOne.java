package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saucedemo.base.BasePageObject;

import java.util.List;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CheckoutStepOne extends BasePageObject {

    private final By buttonCancel = id("cancel");
    private final By buttonContinue = id("continue");
    private final By buttonErrorCloseMessage = xpath("//button[@class='error-button']");
    private final By inputFirstName = id("first-name");
    private final By inputLastName = id("last-name");
    private final By inputPostalCode = id("postal-code");
    private final By errorMessage = xpath("//div[@class='error-message-container error']");
    private final By errorIconInInputField_NotUnique = xpath("//div[@class='form_group']//*[@data-prefix='fas']");
    private final By errorInputFields_NotUnique = xpath("//input[@class='input_error form_input error']");
    private final int NO_OF_INPUT_FIELDS = 3;

    public void clickCancelButton(){

        driver.findElement(buttonCancel).click();
    }

    public void clickContinueButton(){

        driver.findElement(buttonContinue).click();
    }

    public void clickCloseErrorMessageButton(){

        driver.findElement(buttonErrorCloseMessage).click();
    }

    public void inputFirstName(String input){

        driver.findElement(inputFirstName).sendKeys(input);
    }

    public void inputLastName(String input){

        driver.findElement(inputLastName).sendKeys(input);
    }

    public void inputPostalCode(String input){

        driver.findElement(inputPostalCode).sendKeys(input);
    }

    public boolean isErrorMessageDisplayed(){

        return isElementDisplayed(errorMessage);
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