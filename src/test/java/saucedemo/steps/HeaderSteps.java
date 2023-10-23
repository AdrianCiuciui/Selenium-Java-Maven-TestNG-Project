package saucedemo.steps;

import saucedemo.pageobjects.Header;

public class HeaderSteps {
    private final Header header;

    public HeaderSteps(){
        header = new Header();
    }

    public void checkPageIsDisplayed(){
        header.checkTitleIsDisplayed();
    }

}
