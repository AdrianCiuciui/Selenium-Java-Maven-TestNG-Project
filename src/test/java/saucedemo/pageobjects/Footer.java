package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.base.BasePageObject;

import static org.openqa.selenium.By.xpath;

public class Footer extends BasePageObject {

    private By footerArea = xpath("//footer[@class='footer']");
    private By footerCopyright = xpath("//div[@class='footer_copy']");
    private By socialTwitter = xpath("//li[@class='social_twitter']");
    private By socialFacebook = xpath("//li[@class='social_facebook']");
    private By socialLinkedin = xpath("//li[@class='social_LinkedIn']");


    public Footer(WebDriver driver) {
        super(driver);
    }


    public boolean isFooterDisplayed(){

        return driver.findElement(footerArea).isDisplayed();
    }

    public boolean isSocialsDisplayed(){

        return (
            driver.findElement(socialTwitter).isDisplayed() &&
            driver.findElement(socialFacebook).isDisplayed() &&
            driver.findElement(socialLinkedin).isDisplayed());
    }

    public String getCopyrightInformation(){

        return driver.findElement(footerCopyright).getText();
    }
}