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

        assertThat(driver.findElement(footerArea).isDisplayed(), is(true));
    }

    public void checkSocialsAreDisplayed(){

        assertThat(driver.findElement(socialTwitter).isDisplayed(), is(true));
        assertThat(driver.findElement(socialFacebook).isDisplayed(), is(true));
        assertThat(driver.findElement(socialLinkedin).isDisplayed(), is(true));
    }

    public String getCopyrightInformation(){

        return driver.findElement(footerCopyright).getText();
    }

}