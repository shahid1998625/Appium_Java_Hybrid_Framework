package com.QM.PracticeTestCasesHybridApp;

import com.QM.Base.BaseClass1;
import com.QM.pageObjects.android.BuiltInGmailpage;
import com.QM.pageObjects.android.InBuiltApp;
import com.QM.utils.ExcelUtil;
import com.QM.utils.ExtentReportUtil;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//@Listeners(com.QM.utils.Listeners.class)
public class GmailApp_Practice extends BaseClass1 {
        BuiltInGmailpage gmapp;
        ExcelUtil Exsheet;
        InBuiltApp ib;

   @Test()
   public void test() throws InterruptedException {
       setup_BuiltIn();
       gmapp = new BuiltInGmailpage(driver);
       ExtentReportUtil.getTest().info("Given user launches Gallery application and performs swipe actions");
       gmapp.clickGmailappBtn();
       ExtentReportUtil.logPassWithScreenshot(driver,"Gmail Application is opened");
       gmapp.clickonComposeBtn();
       ExtentReportUtil.logPassWithScreenshot(driver,"Clicked on Compose button");
   }


    @Test(dataProvider = "getData")
    public void testGmailmail(HashMap<String,String>input) throws InterruptedException {
        ExtentReportUtil.logPassWithScreenshot(driver,"Compose Email is clicked and navigated to new email page ");
        gmapp.clickonToBtn(input.get("ToEmail"));
        gmapp.enterSubject(input.get("Subject"));
        gmapp.entermailText(input.get("EmailText"));
        ExtentReportUtil.logPassWithScreenshot(driver,"Email drafted with To, Subject, Email text details");
        gmapp.clickOnAndroidBackBtn();
        gmapp.clickSendEmailBtn();
        Thread.sleep(5000);
        ExtentReportUtil.logPassWithScreenshot(driver,"Email is sent");
        gmapp.clickNavigationBtn();
        gmapp.clickonSentBtn();
        ExtentReportUtil.logPassWithScreenshot(driver,"Opened sent mails");
        Thread.sleep(4000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @DataProvider()
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//resources//testData//eComm.json");
        return new Object[][]{{data.get(4)}};
    }

}