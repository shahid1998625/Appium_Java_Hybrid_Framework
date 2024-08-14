package com.QM.utils;

import com.QM.drivers.AndroidDriverManager1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ExtentReportUtil extends AndroidDriverManager1 {
    private static ExtentReports extent;
    static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;


    public static void setup() {
        System.out.println("Setting up ExtentReports...");
        if (extent == null) {
//            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")  + "/reports/extent-reports/extent-report" + System.currentTimeMillis() + ".html");
//            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")  + "/reports/extent-report-withlogs/extent-report" + System.currentTimeMillis() + ".html");
            sparkReporter = new ExtentSparkReporter("reports2/extent-report.html");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Extent Practice reports");
            sparkReporter.config().setReportName("Mobile Appium Automation results");
            sparkReporter.config().setTimeStampFormat("Time:");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Shahid");
        }
    }

    public static void startTest(String testName) {
        System.out.println("Starting test: " + testName);
        if (extent != null) {
            test = extent.createTest(testName);
        } else {
            throw new IllegalStateException("ExtentReports is not initialized. Call setup() first.");
        }
    }

    public static ExtentTest getTest() {
        if (test == null) {
            throw new IllegalStateException("ExtentTest is not initialized. Call startTest() first.");
        }
        return test;
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static String captureScreenshotAsBase64(AndroidDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }


    public static void logPassWithScreenshot(AndroidDriver driver, String message) {
        String base64Screenshot = captureScreenshotAsBase64(driver);
        test.pass(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void logFailWithScreenshot(AndroidDriver driver, String message) {
        String base64Screenshot = captureScreenshotAsBase64(driver);
        test.fail(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void attachScreenshot(String base64Screenshot) {
        test.addScreenCaptureFromBase64String(base64Screenshot);
    }


    public static void tearingDown(Scenario scenario, String message) {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        if (scenario.isFailed()) {
            String base64Screenshot = captureScreenshotAsBase64(driver);
            scenario.attach(base64Screenshot, "image/jpeg", "Failed Step Screenshot");
        } else {
            test.pass("Test Passed");
        }
    }


    public static void flushReport() {
        System.out.println("Closing/flushing down ExtentReports...");
        if (extent != null) {
            extent.flush();
        }
    }
}

