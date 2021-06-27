package com.bridgelabz.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.bridgelabz.base.Base.logger;

public class ShippingAddressPage {

    @FindBy(id = "ctl00_cpBody_txtNewRecipientName")
    WebElement recipientName;

    @FindBy(id = "ctl00_cpBody_txtNewCompanyName")
    WebElement companyName;

    @FindBy(id = "ctl00_cpBody_txtNewAddress")
    WebElement address;

    @FindBy(id = "ctl00_cpBody_txtNewLandmark")
    WebElement landmark;

    @FindBy(id = "ctl00_cpBody_ddlNewCountry")
    WebElement country;

    @FindBy(id = "ctl00_cpBody_ddlNewState")
    WebElement state;

    @FindBy(id = "ctl00_cpBody_ddlNewCities")
    WebElement city;

    @FindBy(id = "ctl00_cpBody_txtNewPincode")
    WebElement zipCode;

    @FindBy(id = "ctl00_cpBody_txtNewMobile")
    WebElement phone;

    @FindBy(id = "ctl00_cpBody_imgSaveNew")
    WebElement saveBtn;


    public ShippingAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void enter_Shipping_Address() throws InterruptedException {
        logger.info("enter address details");
        recipientName.sendKeys("Mayur Mansukh");
        companyName.sendKeys("BridgeLabz");
        address.sendKeys("ghatkoper West mumbai");
        landmark.sendKeys("genesh medical");
        Thread.sleep(500);
        country.click();
        Select select = new Select(country);
        select.selectByVisibleText("India");
        Thread.sleep(500);
        state.click();
        Select select2 = new Select(state);
        select2.selectByVisibleText("Maharashtra");
        Thread.sleep(500);
        city.click();
        Select select3 = new Select(city);
        select3.selectByVisibleText("Mumbai");
        Thread.sleep(500);
        zipCode.sendKeys("400081");
        phone.sendKeys("8889996667770");
        saveBtn.click();
    }
}
