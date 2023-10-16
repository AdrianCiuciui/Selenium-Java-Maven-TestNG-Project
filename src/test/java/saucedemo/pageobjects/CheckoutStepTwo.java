package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CheckoutStepTwo extends Cart {

    private final By labelPriceItemsTotal = xpath("//div[@class='summary_subtotal_label']");
    private final By labelPriceTax = xpath("//div[@class='summary_tax_label']");
    private final By labelPriceTotal = xpath("//div[@class='summary_info_label summary_total_label']");
    private final By buttonCancel = xpath("//button[@id='cancel']");
    private final By buttonFinish = xpath("//button[@id='finish']");


    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }


    public CheckoutStepTwo clickCancelButton(){

        driver.findElement(buttonCancel).click();
        return this;
    }

    public CheckoutStepTwo clickFinishButton(){

        driver.findElement(buttonFinish).click();
        return this;
    }

    public String getProductsTotalPrice(){

        return (driver.findElement(labelPriceItemsTotal).getText().substring(13));
    }

    public String getProductTaxPrice(){

        return (driver.findElement(labelPriceTax).getText().substring(6));
    }

    public String getProductFinalTotalPrice(){

        return (driver.findElement(labelPriceTotal).getText().substring(8));
    }

}