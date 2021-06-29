/**
 * Description : add Test to check update cart
 * Author      : Mayur Mansukh
 * Date        : 18/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.Bookswagon_cart_Update;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class BooksWagonCartUpdateTest extends Base {

    @Test
    public void AddToCart() throws Exception {
        Bookswagon_cart_Update cart_popup = new Bookswagon_cart_Update(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
        cart_popup.login();
        cart_popup.addToCart();
        cart_popup.changeQuantity();
        Thread.sleep(1400);
        cart_popup.updatePostiveQuantity();
        Thread.sleep(1400);
        Assert.assertEquals(cart_popup.cartUpdatePostiveValidation(), "2");
    }

}
