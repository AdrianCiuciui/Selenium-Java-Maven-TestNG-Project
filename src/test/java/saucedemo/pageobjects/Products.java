package saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;

public class Products extends Menu{

    private String buttonProductAllSection = "(//div[@class='inventory_item'])[%d]";
    private String buttonProductImage = "//*[@class='inventory_item_img']//*[contains(@id,'item')]";
    private String buttonProductTitle = "//*[@class='inventory_item_label']//*[contains(@id,'item')]";



    public Products(WebDriver driver) {
        super(driver);
    }







}