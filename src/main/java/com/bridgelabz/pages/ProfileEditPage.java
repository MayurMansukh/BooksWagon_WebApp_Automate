/**
 * Description : add BooksWagon web profile Edit page locators and methods
 * Author      : Mayur Mansukh
 * Date        : 18/6/21
 */
package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ProfileEditPage extends Base {

    @FindBy(xpath = "//*[@id=\"ctl00_divLogged\"]/ul/li/a/span")
    WebElement myprofile;

    @FindBy(xpath = "//*[@id=\"ctl00_divLogged\"]/ul/li/div/div/div[1]/ul/li[2]/a")
    WebElement personal_setting;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_imgUpdate")
    WebElement editBtn;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_txtFName")
    WebElement firstName;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_txtLName")
    WebElement lastName;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_txtFax")
    WebElement faxNo;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_txtMobile")
    WebElement phone;

    @FindBy(id = "ctl00_phBody_AccountSetting_fvCustomer_imgUpdate")
    WebElement editSubmitBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_AccountSetting_fvCustomer_lnkbtnCancel\"]")
    WebElement editCancelBtn;

    public ProfileEditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void user_login(String userName,String password){
        logger.info("user loging");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickSubmitBtn();
    }

    public void click_account_setting_btn(){
        logger.info("click user profile opt");
        myprofile.click();
        personal_setting.click();
    }

    public void click_edit_btn(){
        logger.info("click edit btn");
        editBtn.click();
    }

    public void enter_details(String fName,String lName,String fax){
        logger.info("enter user profile details");
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        faxNo.sendKeys(fax);
    }

    public void enterPhone(String phoneNo) {
        logger.info("replace new phone no");
        for (int i=1 ; i<=10; i++) {
            phone.sendKeys(Keys.BACK_SPACE);
        }
        phone.sendKeys(phoneNo);

    }

    public void click_submit_btn(){
        logger.info("click submit btn");
        editSubmitBtn.click();
    }

    public void click_cancel_btn(){
        logger.info("click submit btn");
        editCancelBtn.click();
    }
}
