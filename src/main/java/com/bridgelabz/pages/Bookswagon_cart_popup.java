/**
 * Description : add BooksWagon web AddToCart page locators and methods
 * Author      : Mayur Mansukh
 * Date        : 17/6/21
 */
package com.bridgelabz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static com.bridgelabz.base.Base.logger;

public class Bookswagon_cart_popup {

    public WebDriver driver;

    @FindBy(id = "ctl00_TopSearch1_txtSearch")
    WebElement searchText;

    @FindBy(id = "ctl00_TopSearch1_Button1")
    WebElement searchBtn;

    @FindBy(partialLinkText = "Greatest Horror")
    WebElement BooksSelect;

    @FindBy(className = "btn-red")
    WebElement BuyNowBtn;

    @FindBy(id = "cboxClose")
    WebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"topright-menu\"]/div[2]/div[1]/a")
    WebElement CartBtn;

    public Bookswagon_cart_popup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addToCart() {
        logger.info("add product into cart");
        searchText.sendKeys("Horror");
        searchBtn.click();
        BooksSelect.click();
        BuyNowBtn.click();
        closeBtn.click();
    }

    public void changeQuantity() {
        logger.info("click cart btn");
        CartBtn.click();

    }

    public void updateQuantity() throws InterruptedException {
        logger.info("update quantity");
        driver.switchTo().frame(1);
        WebElement textbox = driver.findElement(By.xpath("//*[@id=\"BookCart_lvCart_ctrl0_txtQty\"]"));
        textbox.sendKeys(Keys.BACK_SPACE);
        textbox.sendKeys(Keys.NUMPAD2);
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement closebox = driver.findElement(By.xpath("//*[@id=\"BookCart_uplnShopping\"]/div[4]/table/tbody/tr/td[1]/a/span"));
        closebox.click();
    }

    public String cartUpdateValidation() {
        String cart = CartBtn.getText();
        return cart;
    }
}
