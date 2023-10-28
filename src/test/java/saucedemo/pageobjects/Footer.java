package saucedemo.pageobjects;

import org.openqa.selenium.By;
import saucedemo.base.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.xpath;

public class Footer extends BasePageObject {

    private final By footerArea = xpath("//footer[@class='footer']");
    private final By footerCopyright = xpath("//div[@class='footer_copy']");
    private final By socialTwitter = xpath("//li[@class='social_twitter']");
    private final By socialFacebook = xpath("//li[@class='social_facebook']");
    private final By socialLinkedin = xpath("//li[@class='social_LinkedIn']");

    public void checkFooterIsDisplayed(){

        assertThat(isElementDisplayed(footerArea), is(true));
    }

    public void checkSocialsAreDisplayed(){

        assertThat(isElementDisplayed(socialTwitter), is(true));
        assertThat(isElementDisplayed(socialFacebook), is(true));
        assertThat(isElementDisplayed(socialLinkedin), is(true));
    }

    public String getCopyrightInformation(){

        return getTextFromField(footerCopyright);
    }

}