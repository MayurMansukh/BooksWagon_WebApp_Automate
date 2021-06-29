package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Base {

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_btnCCAvenue\"]")
    WebElement payNowWithBtn;

    @FindBy(id = "creditCardNumber")
    WebElement cardNO;

    @FindBy(id = "expiryMonthCreditCard")
    WebElement expireMonth;

    @FindBy(id = "expiryYearCreditCard")
    WebElement expireYear;

    @FindBy(id = "CVVNumberCreditCard")
    WebElement cvvNo;

    @FindBy(xpath = "//*[@id=\"SubmitBillShip\"]/span")
    WebElement payNowBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_plnTransactionDecline\"]/a[2]/input")
    WebElement contShoppingBtn;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectPaymentOpt() throws InterruptedException {
        logger.info("select payment option");
        payNowWithBtn.click();
        logger.info("select sub payment option");
        cardNO.sendKeys("4005550000000019");
        expireMonth.click();
        Select select = new Select(expireMonth);
        select.selectByVisibleText("Apr (04)");
        Thread.sleep(1000);
        expireYear.click();
        Select select2 = new Select(expireYear);
        select2.selectByVisibleText("2023");
        Thread.sleep(1000);
        cvvNo.sendKeys("111");
        payNowBtn.click();
        Thread.sleep(1000);
        logger.info("get payment success message");
    }

    public void clickContShopping() {
        logger.info("continue shopping");
        contShoppingBtn.click();
    }
}
