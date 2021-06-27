package com.bridgelabz.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

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
        payNowWithBtn.click();
        cardNO.sendKeys("4005550000000019");
        expireMonth.click();
        expireMonth.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
        expireYear.click();
        expireYear.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
        cvvNo.sendKeys("111");
        payNowBtn.click();
        Thread.sleep(1000);
        contShoppingBtn.click();
    }

}
