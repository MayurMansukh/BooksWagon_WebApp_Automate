/**
 * Description : add Test to check buy product with payment
 * Author      : Mayur Mansukh
 * Date        : 29/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(CustomListener.class)
public class BuyProductWithPositiveCredentialsTest extends Base {

    @Test
    public void buy_product_With_Payment() throws InterruptedException, IOException {
        BuyProductWithPositiveCredentials buyProduct = new BuyProductWithPositiveCredentials(driver);
        ShippingAddressPage shipping = new ShippingAddressPage(driver);
        ReviewOrderPage review = new ReviewOrderPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
        buyProduct.loginPage();
        Thread.sleep(500);
        buyProduct.addToCart();
        Thread.sleep(500);
        buyProduct.placeOrder();
        Thread.sleep(500);
        shipping.enter_Shipping_Address();
        Thread.sleep(500);
        review.reviewOrder();
        Thread.sleep(500);
        checkout.selectPaymentOpt();
        Thread.sleep(500);
        Assert.assertEquals(buyProduct.testValidation(),"Thank you for shopping with us. However,the transaction has been declined.");
    }


}
