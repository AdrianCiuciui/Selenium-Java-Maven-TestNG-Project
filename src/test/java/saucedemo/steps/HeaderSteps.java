package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.Header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HeaderSteps {
    private final Header header;

    public HeaderSteps(){
        header = new Header();
    }


    public HeaderSteps checkPageIsDisplayed(){

        assertThat(header.isTitleDisplayed(), is(true));
        return this;
    }

}
