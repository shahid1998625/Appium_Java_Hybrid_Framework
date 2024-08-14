package com.QM.utils;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static com.QM.drivers.AndroidDriverManager1.driver;


public class Listeners implements ITestListener {

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
        ExtentReportUtil.logPassWithScreenshot(driver, n);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtil.getTest().fail(result.getThrowable());
        ExtentReportUtil.logFailWithScreenshot(driver, "Test Case Failed");
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





