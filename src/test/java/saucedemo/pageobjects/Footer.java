package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.className;

public class Footer extends BasePageObject {

    private final By footerArea = className("footer");
    private final By footerCopyright = className("footer_copy");
    private final By socialTwitter = className("social_twitter");
    private final By socialFacebook = className("social_facebook");
    private final By socialLinkedin = className("social_linkedin");

    public void checkFooterIsDisplayed(){

        assertThat(isElementDisplayed(footerArea), is(true));
    }

    public void checkSocialsAreDisplayed(){

        assertThat("Twitter icon not displayed", isElementDisplayed(socialTwitter), is(true));
        assertThat("Facebook icon not displayed", isElementDisplayed(socialFacebook), is(true));
        assertThat("LinkedIn icon not displayed", isElementDisplayed(socialLinkedin), is(true));
    }

    public String getCopyrightInformation(){

        return getTextFromField(footerCopyright);
    }

}