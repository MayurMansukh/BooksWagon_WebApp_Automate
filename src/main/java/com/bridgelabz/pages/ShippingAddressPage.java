package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.bridgelabz.base.Base.logger;

public class ShippingAddressPage extends Base {

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

    public void enter_Shipping_Address() throws InterruptedException, IOException {
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream("/Users/manojmansukh/IdeaProjects/BooksWagon_WebApp_Automate/application.properties");
        obj.load(objfile);
        Thread.sleep(2000);
        logger.info("enter address details");
        recipientName.sendKeys(obj.getProperty("recipientName"));
        companyName.sendKeys(obj.getProperty("companyName"));
        address.sendKeys(obj.getProperty("address"));
        landmark.sendKeys(obj.getProperty("landmark"));
        Thread.sleep(500);
        country.click();
        Select select = new Select(country);
        select.selectByVisibleText(obj.getProperty("country"));
        Thread.sleep(500);
        state.click();
        Select select2 = new Select(state);
        select2.selectByVisibleText(obj.getProperty("state"));
        Thread.sleep(500);
        city.click();
        Select select3 = new Select(city);
        select3.selectByVisibleText(obj.getProperty("city"));
        Thread.sleep(500);
        zipCode.sendKeys(obj.getProperty("zipCode"));
        phone.sendKeys(obj.getProperty("phone"));
        saveBtn.click();
    }
}
