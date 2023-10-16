package saucedemo.steps;

import org.openqa.selenium.WebDriver;
import saucedemo.pageobjects.CheckoutStepTwo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckoutTwoSteps {
    private final CheckoutStepTwo checkoutStepTwo;

    public CheckoutTwoSteps() {
        checkoutStepTwo = new CheckoutStepTwo();
    }

    public void checkTotalPriceValue(){

        double priceTotal = Double.parseDouble(checkoutStepTwo.getProductsTotalPrice());
        double priceTax = Double.parseDouble(checkoutStepTwo.getProductTaxPrice());
        String priceFinalTotal = checkoutStepTwo.getProductFinalTotalPrice();

        double sumFromTotalAndTax = priceTotal + priceTax;
        String formattedSum = String.format("%.2f", sumFromTotalAndTax);

        assertThat(formattedSum, is(priceFinalTotal));
    }

    public void pressFinishButton(){
        checkoutStepTwo.clickFinishButton();
    }

}