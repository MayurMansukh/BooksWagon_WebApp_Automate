package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.bridgelabz.base.Base.logger;

public class ReviewOrderPage extends Base {

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
        logger.info("review order");
        giftMsg.sendKeys("congratulation!!!!!!");
        instruction.sendKeys("Thank you");
        saveBtn.click();
    }

}
