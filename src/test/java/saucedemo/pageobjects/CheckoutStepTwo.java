package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CheckoutStepTwo extends Cart {

    private final By labelPriceItemsTotal = className("summary_subtotal_label");
    private final By labelPriceTax = className("summary_tax_label");
    private final By labelPriceTotal = xpath("//div[@class='summary_info_label summary_total_label']");
    private final By labelPriceAllItemsValues = xpath("//*[@class='inventory_item_price']");
    private final By buttonCancel = id("cancel");
    private final By buttonFinish = id("finish");

    public void clickCancelButton(){

        driver.findElement(buttonCancel).click();
    }

    public void clickFinishButton(){

        driver.findElement(buttonFinish).click();
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

    public int getNumberOfProductsInCheckout(){

        return driver.findElements(labelPriceAllItemsValues).size();
    }

    public double getPriceForItem(int index){

        String asString = String.valueOf(labelPriceAllItemsValues).substring(10);
        String asStringModified = "("+ asString + ")[%d]";
        By asBy = By.xpath(String.format(asStringModified, index + 1));
        WebElement webElement = driver.findElement(asBy);
        return Double.parseDouble(webElement.getText().substring(1));
    }

}