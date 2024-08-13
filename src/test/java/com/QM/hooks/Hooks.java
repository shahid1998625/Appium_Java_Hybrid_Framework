package com.QM.hooks;

import com.QM.Base.BaseClass1;
import com.QM.utils.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;

public class Hooks extends BaseClass1 implements IInvokedMethodListener, IExecutionListener, ITestListener {

//    @Override
//    public void onExecutionStart() {
//        ExtentReportUtil.setup();
//    }
//
//    @Override
//    public void onExecutionFinish() {
//        ExtentReportUtil.flushReport();
//    }
//
//    @BeforeClass
//    public void setUpClass() {
//        System.out.println("Setting up before class");
//    }
//
//    @AfterClass
//    public void tearDownClass() {
//        System.out.println("Tearing down after class");
//    }
//
//    @BeforeMethod
//    public void setUpMethod() throws InterruptedException {
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.out.println("Driver initialized before method");
//    }
//
//    @AfterMethod
//    public void tearDownMethod(ITestResult result) throws InterruptedException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            ExtentReportUtil.logFail(result.getThrowable().getMessage());
//            String base64Screenshot = ExtentReportUtil.captureScreenshotAsBase64(driver);
//            ExtentReportUtil.logFailWithScreenshot(driver, base64Screenshot);
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            String base64Screenshot = ExtentReportUtil.captureScreenshotAsBase64(driver);
//            ExtentReportUtil.logPassWithScreenshot(driver, base64Screenshot);
//            ExtentReportUtil.logPass("Test passed");
//        }
//
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Driver quit after method");
//        }
//    }
//
//    @Override
//    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//        if (method.isTestMethod()) {
//            ExtentReportUtil.startTest(testResult.getMethod().getMethodName());
//        }
//    }
//
//    @Override
//    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//        if (method.isTestMethod()) {
//            ExtentReportUtil.tearDown();
//        }
//    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
        ExtentReportUtil.setup();
        ExtentReportUtil.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("After Scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            ExtentReportUtil.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentReportUtil.getTest().pass("Scenario passed: " + scenario.getName());
        }
        ExtentReportUtil.tearingDown(scenario,"test case Failed");
    }

}
