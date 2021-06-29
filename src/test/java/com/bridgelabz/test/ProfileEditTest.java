/**
 * Description : add BooksWagon web profile Edit page Test
 * Author      : Mayur Mansukh
 * Date        : 18/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.ProfileEditPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ProfileEditTest extends Base {

    @Test
    public void profileEdit() {
        ProfileEditPage edit = new ProfileEditPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/");

        edit.user_login("mansukhmayur99@gmail.com","Password1@2");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/myaccount.aspx");

        edit.click_account_setting_btn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/accountsetting.aspx");

        edit.click_edit_btn();
        edit.enter_details("Mayur","Mansukh","MH1234567");
        edit.enterPhone("9989898978");

        //edit.click_submit_btn();
        edit.click_cancel_btn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/accountsetting.aspx");
    }

}
