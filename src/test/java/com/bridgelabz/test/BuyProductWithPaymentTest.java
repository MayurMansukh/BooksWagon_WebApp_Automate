package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.BuyProductWithPaymentPage;
import com.bridgelabz.pages.CheckoutPage;
import com.bridgelabz.pages.ReviewOrderPage;
import com.bridgelabz.pages.ShippingAddressPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductWithPaymentTest extends Base {

    @Test
    public void buy_product_With_Payment() throws InterruptedException {
        BuyProductWithPaymentPage buyProduct = new BuyProductWithPaymentPage(driver);
        ShippingAddressPage shipping = new ShippingAddressPage(driver);
        ReviewOrderPage review = new ReviewOrderPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
        buyProduct.loginPage();
        Thread.sleep(1000);
        buyProduct.addToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/book/50-greatest-horror-stories-terry/9789353043636");
        Thread.sleep(1000);
        buyProduct.placeOrder();
        Thread.sleep(1000);
        shipping.enter_Shipping_Address();
        Thread.sleep(1000);
        review.reviewOrder();
        Thread.sleep(1000);
        checkout.selectPaymentOpt();
    }

}
