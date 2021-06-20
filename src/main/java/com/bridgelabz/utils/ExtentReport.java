/**
 * Description : add extent report method
 * Author      : Mayur Mansukh
 * Date        : 9/6/21
 */
package com.bridgelabz.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class ExtentReport {
    static ExtentTest test;
    static ExtentReports report;

    @BeforeTest
    public void startTest() {
        System.setProperty("org.freemarker.loggerLibrary", "none");
        report = new ExtentReports(System.getProperty("C:\\Users\\admin\\IdeaProjects\\Naukri.com_Web_Application") + "ExtentReportResults.html");
        test = report.startTest("Test_object_properties_method");
        System.out.println(System.getProperty("user.dir"));
    }

    @AfterClass
    public void endTest() throws Exception {
        report.endTest(test);
        report.flush();
    }

}
