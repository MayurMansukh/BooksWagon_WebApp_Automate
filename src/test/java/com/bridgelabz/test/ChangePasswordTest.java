package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.ChangePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest  extends Base {

    @Test
    public void changePassword(){
        ChangePasswordPage changePassword = new ChangePasswordPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/");
        changePassword.user_login("mansukhmayur99@gmail.com","Password1@2");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/myaccount.aspx");
        changePassword.click_change_Password_btn();
        changePassword.enterPasswordDetails("Password1@2","Password1@2","Password1@2");
        changePassword.click_submit_cancel_Btn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bookswagon.com/changepassword.aspx");
    }
}
