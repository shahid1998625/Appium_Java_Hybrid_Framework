package com.QM.PracticeTestCasesHybridApp;

import com.QM.Base.BaseClass1;
import com.QM.pageObjects.android.CartPage;
import com.QM.pageObjects.android.FormPage;
import com.QM.pageObjects.android.ProductCataloguePage;
import com.QM.utils.ExtentReportUtil;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class TC_02_Practice extends BaseClass1 {
    FormPage fp;

    @Test(dataProvider = "getData")
    public void EcomappTest2(HashMap<String, String> input) throws InterruptedException {
        ExtentReportUtil.getTest().info("Given user launches the Ecomm General Store application");
        setup_ExtApp();
        fp = new FormPage(driver);
        fp.setNamefield(input.get("name"));
        ExtentReportUtil.logPassWithScreenshot(driver, "Name is entered");
        Thread.sleep(5000);
        fp.setGender(input.get("gender"));
        ExtentReportUtil.logPassWithScreenshot(driver, "Gender is selected");
        fp.setCountryselection(input.get("country"));
        ExtentReportUtil.logPassWithScreenshot(driver, "Country is clicked");
        ProductCataloguePage pcp = fp.submitForm();
        pcp.addItemtoCartByIndex(0);
        pcp.addItemtoCartByIndex(1);
        ExtentReportUtil.logPassWithScreenshot(driver, "Two products added to cart");
        CartPage cp = pcp.goToCartPage();
        double totalSum = cp.totalSumofProducts();
        double totalFormattedSum = cp.getTotalSumAmountDisplayed();
        ExtentReportUtil.logPassWithScreenshot(driver, "cart Page is opened and verified the total sum");
        try {
            Assert.assertEquals(totalSum, totalFormattedSum);
        } catch (AssertionError e) {
            throw e;
        }
        cp.acceptTermsConditions();
        cp.SubmitOrder();
        ExtentReportUtil.logPassWithScreenshot(driver, "Order is submitted");
        Thread.sleep(6000);
        getContextsoftheMobileDevice();
        driver.context(input.get("WebViewContext"));
        ExtentReportUtil.logPassWithScreenshot(driver, "Navigated to Web App");
        getChromeNativeApp(input.get("company"));
        ExtentReportUtil.logPassWithScreenshot(driver, "Company is searched");
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        ExtentReportUtil.logPassWithScreenshot(driver, "Back to Native App");
        driver.context(input.get("NativeAppContext"));
//        Thread.sleep(5000);
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @DataProvider()
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//resources//testData//eComm.json");
//        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}, {data.get(3)}};
        return new Object[][]{{data.get(0)}};
    }

    public void getChromeNativeApp(String com) {
        WebElement textBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        waitForElementToAppear(textBox);
        textBox.sendKeys(com);
        textBox.sendKeys(Keys.ENTER);
    }

    public void getContextsoftheMobileDevice() {
        Set<String> contexts = driver.getContextHandles();
        for (String IndividualContexts : contexts) {
            System.out.println(IndividualContexts);
        }
    }


}