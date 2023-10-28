package saucedemo.steps;

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

        // the product with ID = 0 can return extra 0's in some cases so the total can be affected
        double sumFromTotalAndTax = priceTotal + priceTax;
        String formattedSum = String.format("%.2f", sumFromTotalAndTax);

        assertThat(formattedSum, is(priceFinalTotal));
    }

    public void checkTotalSumValueOfProducts(){

        int numberOfItemsInCheckout = checkoutStepTwo.getNumberOfProductsInCheckout();
        double sum = 0;
        for (int i = 0; i < numberOfItemsInCheckout; i++) {
            sum += checkoutStepTwo.getPriceForItem(i);
        }
        String sumFromCheckout = checkoutStepTwo.getProductsTotalPrice();
        double sumFromCheckoutConverted = Double.parseDouble(sumFromCheckout);
        assertThat(sum, is(sumFromCheckoutConverted));
    }
}