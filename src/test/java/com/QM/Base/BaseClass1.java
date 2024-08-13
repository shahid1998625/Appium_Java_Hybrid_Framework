package com.QM.Base;

import com.QM.drivers.AndroidDriverManager1;
import com.QM.pageObjects.android.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseClass1 {

    protected static AndroidDriver driver;
    protected AppiumDriverLocalService service;
    protected FormPage fp;

    public void setup_ExtApp() throws InterruptedException {
        driver = AndroidDriverManager1.getDriver();
//        service = AndroidDriverManager.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void setup_BuiltIn(){
        driver = AndroidDriverManager1.getDriver_2();
//        service = AndroidDriverManager.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {

                });
        return data;
    }

    public void waitForElementToAppear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
    }

    public String getScreenshotPath(String testcaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir") + "/Screenshots/report" + testcaseName + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(source, new File(destFile));
        return destFile;
    }


}
