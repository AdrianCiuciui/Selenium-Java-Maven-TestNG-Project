package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HeaderSteps {


    protected WebDriver driver;
    private final Header header;

    public HeaderSteps(WebDriver driver){

        this.driver = driver;
        header = new Header(driver);
    }


    public HeaderSteps checkPageIsDisplayed(){

        assertThat(header.isTitleDisplayed(), is(true));
        return this;
    }

}
