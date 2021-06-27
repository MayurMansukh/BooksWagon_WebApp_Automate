/**
 * Description : add BooksWagon web AddToCart page locators and methods
 * Author      : Mayur Mansukh
 * Date        : 17/6/21
 */
package com.bridgelabz.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.base.Base.logger;

public class BuyProductWithPaymentPage {

    public WebDriver driver;

    @FindBy(id = "ctl00_TopSearch1_txtSearch")
    WebElement searchText;

    @FindBy(id = "ctl00_TopSearch1_Button1")
    WebElement searchBtn;

    @FindBy(partialLinkText = "Greatest Horror")
    WebElement BooksSelect;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ProductDetail_divAddtoCart\"]/a/input")
    WebElement BuyNowBtn;

    @FindBy(id = "cboxClose")
    WebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"topright-menu\"]/div[2]/div[1]/a")
    WebElement CartBtn;

    @FindBy(name = "BookCart$lvCart$imgPayment")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_plnLogged\"]/div/div/div/a")
    WebElement continueBtn;

    public BuyProductWithPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.enterUserName("mansukhmayur99@gmail.com");
        loginPage.enterPassword("Password1@2");
        loginPage.clickSubmitBtn();
    }

    public void addToCart() {
        logger.info("add product into cart");
        searchText.sendKeys("Horror");
        searchBtn.click();
        BooksSelect.click();
        BuyNowBtn.click();
        closeBtn.click();
        CartBtn.click();
    }

    public void placeOrder() throws InterruptedException {
        logger.info("Place order");
        driver.switchTo().frame(1);
        Thread.sleep(500);
        placeOrderBtn.click();
        driver.switchTo().parentFrame();
        Thread.sleep(500);
        continueBtn.click();
    }

}
