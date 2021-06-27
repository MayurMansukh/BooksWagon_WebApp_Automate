package com.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrderPage {

    @FindBy(id = "ctl00_cpBody_ShoppingCart_lvCart_txtGiftMessage")
    WebElement giftMsg;

    @FindBy(id = "ctl00_cpBody_ShoppingCart_lvCart_txtInstruction")
    WebElement instruction;

    @FindBy(id = "ctl00_cpBody_ShoppingCart_lvCart_savecontinue")
    WebElement saveBtn;

    public ReviewOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void reviewOrder(){
        giftMsg.sendKeys("congratulation!!!!!!");
        instruction.sendKeys("Thank you");
        saveBtn.click();
    }

}
