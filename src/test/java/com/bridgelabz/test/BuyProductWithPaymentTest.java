package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.*;
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
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/myaccount.aspx");
        buyProduct.addToCart();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/book/50-greatest-horror-stories-terry/9789353043636");
        buyProduct.placeOrder();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/shippingoption.aspx");
        shipping.enter_Shipping_Address();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/viewshoppingcart.aspx");
        review.reviewOrder();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/checkout.aspx");
        checkout.selectPaymentOpt();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/ccavenuereturnurl.aspx");
        checkout.clickContShopping();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
    }

}
