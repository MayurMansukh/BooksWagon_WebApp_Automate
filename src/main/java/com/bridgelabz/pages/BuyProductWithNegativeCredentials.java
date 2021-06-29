/**
 * Description : add BooksWagon web AddToCart page locators and methods
 * Author      : Mayur Mansukh
 * Date        : 17/6/21
 */
package com.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.base.Base.logger;

public class BuyProductWithNegativeCredentials {

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

    @FindBy(id = "ctl00_cpBody_txtEmail")
    WebElement userName;

    @FindBy(id = "ctl00_cpBody_txtPassword")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_imgLogin\"]")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_reEmail\"]")
    WebElement errorMsg;


    public BuyProductWithNegativeCredentials(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithNegetiveData() throws InterruptedException {
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        userName.sendKeys("mansukhmayur99");
        password.sendKeys("Password1@2");
        submitBtn.click();
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        logger.info("add product into cart");
        searchText.sendKeys("Horror");
        searchBtn.click();
        BooksSelect.click();
        BuyNowBtn.click();
        closeBtn.click();
        CartBtn.click();
        Thread.sleep(2000);
    }

    public void placeOrder() throws InterruptedException {
        logger.info("Place order");
        driver.switchTo().frame(1);
        Thread.sleep(1000);
        placeOrderBtn.click();
    }

    public String testNegetiveValidation(){
        String message = errorMsg.getText();
        return message;
    }

}
