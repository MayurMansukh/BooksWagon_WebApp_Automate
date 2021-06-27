/**
 * Description : add Test to check update cart
 * Author      : Mayur Mansukh
 * Date        : 18/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.Bookswagon_cart_popup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksWagonCartTest extends Base {

    @Test
    public void AddToCart() throws Exception {
        Bookswagon_cart_popup cart_popup = new Bookswagon_cart_popup(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
        cart_popup.addToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/book/50-greatest-horror-stories-terry/9789353043636");
        cart_popup.changeQuantity();
        Thread.sleep(1400);
        cart_popup.updateQuantity();
//        Assert.assertEquals(cart_popup.cartUpdateValidation(), "2");
    }

}
