package com.bridgelabz.base;

import com.bridgelabz.utils.ExtentReport;
import com.bridgelabz.utils.Send_TestReport_By_Email;
import com.bridgelabz.utils.checkInternerConnection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public static Logger logger = Logger.getLogger(Base.class);
    checkInternerConnection connection = new checkInternerConnection();
    Send_TestReport_By_Email email = new Send_TestReport_By_Email();
    ExtentReport extentReport = new ExtentReport();

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.bookswagon.com/");
        connection.check_internet_connectivity(); // check internet connection
        extentReport.startTest();
        PropertyConfigurator.configure("log4j.properties");
    }

    @AfterTest
    public void teardown() throws Exception {
        extentReport.endTest(); // create extent report
        //email.sendEmail();
        driver.close();
    }
}
