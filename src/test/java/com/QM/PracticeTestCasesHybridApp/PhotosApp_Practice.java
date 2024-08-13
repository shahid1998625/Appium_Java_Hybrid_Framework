package com.QM.PracticeTestCasesHybridApp;

import com.QM.Base.BaseClass1;
import com.QM.pageObjects.android.InBuiltApp;
import com.QM.utils.ExtentReportUtil;
import com.QM.utils.SwipeUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.devtools.v125.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(com.QM.utils.Listeners.class)
public class PhotosApp_Practice extends BaseClass1 {
        InBuiltApp ib ;
        SwipeUtil swipe ;



    @Test
    public void testPhotosApp() throws InterruptedException {
        setup_BuiltIn();
        ib = new InBuiltApp(driver);
        swipe = new SwipeUtil(driver);
//        ExtentReportUtil.startTest("EcomappTest2");
//        ExtentReportUtil.attachScreenshot(ExtentReportUtil.captureScreenshotAsBase64(driver));
//        ExtentReportUtil.logPassWithScreenshot(driver,"PassedImage");
        ExtentReportUtil.getTest().info("Given user launches Gallery application and performs swipe actions");
        ib.clickGalleryBtn();
        ExtentReportUtil.logPassWithScreenshot(driver,"Opened Gallery Application");
        ib.getCameraBtn();
        ExtentReportUtil.logPassWithScreenshot(driver,"Opened Camera Module");
        ib.totalImagesList();
        Thread.sleep(2000);
        ExtentReportUtil.logPassWithScreenshot(driver,"Total Images in Camera Module");
        swipe.swipeRightToLeft();
        swipe.swipeRightToLeft();
        ExtentReportUtil.logPassWithScreenshot(driver,"Swiping of images done");
        ib.AndroidKeyActions();
    }



}