/**
 * Description : add Test to BooksWagon webApp Login with multiple data
 * Author      : Mayur Mansukh
 * Date        : 18/6/21
 */
package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.listener.CustomListener;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.utils.DataDrivenMethod;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LoginWithMultipleData extends Base {

    @Test
    public void LoginTest() throws Exception {
        DataDrivenMethod drivenMethod = new DataDrivenMethod();
        LoginPage loginPage = new LoginPage(driver);

        XSSFSheet sheet = drivenMethod.excel_utils_base().getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            System.out.println("test started with data " + i);
            loginPage.clickLogin();
            Thread.sleep(1000);
            String username1 = String.valueOf(sheet.getRow(i).getCell(0));
            String password1 = String.valueOf(sheet.getRow(i).getCell(1));

            loginPage.enterUserName(username1);
            Thread.sleep(1000);
            loginPage.enterPassword(password1);
            Thread.sleep(1000);
            boolean check = loginPage.clickSubmitBtn();
            if(check) {
                Thread.sleep(1000);
                loginPage.clickLogoutopt();
                loginPage.clickLogoutBtn();
                System.out.println("test success with data " + i);
            }
            else
                System.out.println("test failed with data " + i);
        }

    }
}
