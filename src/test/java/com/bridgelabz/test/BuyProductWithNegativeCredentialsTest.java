/**
 * Description : add Test to check buy product with negetive credentials
 * Author      : Mayur Mansukh
 * Date        : 29/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.BuyProductWithNegativeCredentials;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class BuyProductWithNegativeCredentialsTest extends Base {

    @Test
    public void buyProductWithNegativeCredentials() throws InterruptedException {
        BuyProductWithNegativeCredentials buyProductFail = new BuyProductWithNegativeCredentials(driver);
        buyProductFail.addToCart();
        buyProductFail.placeOrder();
        buyProductFail.loginWithNegetiveData();
        Assert.assertEquals(buyProductFail.testNegetiveValidation(),"Invalid E-mail");
    }
}
