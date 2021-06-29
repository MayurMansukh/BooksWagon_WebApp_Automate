/**
 * Description : add BooksWagon web AddToCart page locators and methods
 * Author      : Mayur Mansukh
 * Date        : 17/6/21
 */
package com.bridgelabz.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.base.Base.logger;

public class Bookswagon_cart_Update {

    public WebDriver driver;

    @FindBy(id = "ctl00_TopSearch1_txtSearch")
    WebElement searchText;

    @FindBy(id = "ctl00_TopSearch1_Button1")
    WebElement searchBtn;

    @FindBy(partialLinkText = "Greatest Horror")
    WebElement BooksSelect;

    @FindBy(xpath = "//*[@id=\"BookCart_lvCart_ctrl0_txtQty\"]")
    WebElement quantityBox;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ProductDetail_divAddtoCart\"]/a/input")
    WebElement BuyNowBtn;

    @FindBy(id = "cboxClose")
    WebElement closeBtn;

    @FindBy(name = "BookCart$lvCart$imgPayment")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//*[@id=\"topright-menu\"]/div[2]/div[1]/a")
    WebElement CartBtn;

    @FindBy(xpath = "//*[@id=\"BookCart_lvCart_ctrl0_rngQty\"]")
    WebElement errorMsg;

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_OrderSummary_lblTotalItems\"]")
    WebElement itmsCount;



    public Bookswagon_cart_Update(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.enterUserName("mansukhmayur99@gmail.com");
        loginPage.enterPassword("Password1@2");
        loginPage.clickSubmitBtn();
        Thread.sleep(1000);
    }

    public void addToCart() throws InterruptedException {
        logger.info("add product into cart");
        searchText.sendKeys("Horror");
        searchBtn.click();
        BooksSelect.click();
        BuyNowBtn.click();
        Thread.sleep(1000);
        closeBtn.click();
    }

    public void changeQuantity() {
        logger.info("click cart btn");
        CartBtn.click();
    }

    public void updatePostiveQuantity() throws InterruptedException {
        logger.info("update quantity");
        driver.switchTo().frame(1);
        quantityBox.clear();
        quantityBox.sendKeys("2");
        quantityBox.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        placeOrderBtn.click();
        Thread.sleep(2000);
    }

    public void updateNegetiveQuantity() throws InterruptedException {
        driver.switchTo().frame(1);
        quantityBox.clear();
        quantityBox.sendKeys("-1");
        Thread.sleep(2000);
    }

    public String cartUpdatePostiveValidation() {
        String cart = itmsCount.getText();
        return cart;
    }

    public String cartUpdateNegetiveValidation() {
        String cart = errorMsg.getText();
        return cart;
    }
}
