/**
 * Description : add Test to login sucessfully
 * Author      : Mayur Mansukh
 * Date        : 17/6/21
 */

package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.utils.DataDrivenMethod;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LoginTest extends Base {

    @Test
    public void LoginTest() throws Exception {
        DataDrivenMethod drivenMethod = new DataDrivenMethod();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/");
        loginPage.clickLogin();
        Thread.sleep(1000);
        loginPage.enterUserName(drivenMethod.excelData());
        Thread.sleep(1000);
        loginPage.enterPassword(drivenMethod.excelData2());
        Thread.sleep(1000);
        loginPage.clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bookswagon.com/myaccount.aspx");
        Thread.sleep(1000);
        loginPage.clickLogoutopt();
        loginPage.clickLogoutBtn();
    }
}
