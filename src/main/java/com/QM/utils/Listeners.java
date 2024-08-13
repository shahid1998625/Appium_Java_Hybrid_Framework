package com.QM.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.Duration;

import static com.QM.drivers.AndroidDriverManager1.driver;


public class Listeners  implements ITestListener {
    ExtentTest test;
    ExtentReports extent ;
//    AndroidDriver driver;


  /*  @Override
    public void onTestStart(ITestResult result){
//       configExtent();
       ExtentReportUtil.startTest(result.getMethod().getMethodName());
       //       extent.
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.log(Status.PASS,"Test Case Passed");
        ExtentReportUtil.logPassWithScreenshot(driver,"PassedImage");
        test.addScreenCaptureFromPath((result.getMethod().getMethodName()),"Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        test.fail(result.getThrowable());
//        try {
//                driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
//                        .get(result.getInstance());
//            } catch (Exception e1) {
//                e1.printStackTrace();
//        }
        ExtentReportUtil.logFailWithScreenshot(driver,"PassedImage");
        test.addScreenCaptureFromPath((result.getMethod().getMethodName()),"Passed");
//            test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context){
//        test.fail(result.getThrowable());
    // extent.flush();
    }*/


    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtil.setup();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String a = result.getMethod().getMethodName();
        ExtentReportUtil.startTest(a);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String n = result.getMethod().getMethodName();
        ExtentReportUtil.getTest().log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
        ExtentReportUtil.logPassWithScreenshot(driver,n);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtil.getTest().fail(result.getThrowable());
        ExtentReportUtil.logFailWithScreenshot(driver,"Test Case Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtil.getTest().skip("Test Case Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtil.flushReport();
    }
}





