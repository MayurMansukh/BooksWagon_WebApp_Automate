package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends Base {

    @FindBy(xpath = "//*[@id=\"ctl00_divLogged\"]/ul/li/a/span")
    WebElement myprofile;

    @FindBy(xpath = "//*[@id=\"ctl00_divLogged\"]/ul/li/div/div/div[1]/ul/li[7]/a")
    WebElement changePassword;

    @FindBy(id = "ctl00_phBody_ChangePassword_txtCurPwd")
    WebElement currPassword;

    @FindBy(id = "ctl00_phBody_ChangePassword_txtNewPassword")
    WebElement newPassword;

    @FindBy(id = "ctl00_phBody_ChangePassword_txtConfirmPwd")
    WebElement confPassword;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ChangePassword_imgSubmit\"]")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ChangePassword_plnPwd\"]/div/div[6]/table/tbody/tr[2]/td[2]/a/input")
    WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ChangePassword_lblmsg\"]")
    WebElement errorMsg;

    public ChangePasswordPage(WebDriver driver) {
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

    public void click_change_Password_btn(){
        logger.info("click user change_Password opt");
        myprofile.click();
        changePassword.click();
    }

    public void enterPasswordDetails(String cPassword,String nPassword,String cfPassword){
        currPassword.sendKeys(cPassword);
        newPassword.sendKeys(nPassword);
        confPassword.sendKeys(cfPassword);
    }

    public void click_submit_cancel_Btn(){
        changePasswordBtn.click();
        //cancelBtn.click();
    }

    public String testValidation(){
        String message = errorMsg.getText();
        return message;
    }

}
