package com.QM.utils;

//import com.QM.Runner.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

//    public String TestScreenshot(WebDriver driver) {
//        try {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            String srcFile = screenshot.getScreenshotAs(OutputType.BASE64);
//            File destFile = new File("D:\\OTR\\screenshot.jpeg" + System.currentTimeMillis() + ".jpeg");
//            System.out.println("Screenshot taken and saved at: " + destFile.getAbsolutePath());
//            return srcFile;
//        } catch (Exception e) {
//            System.out.println("An error occurred while taking screenshot: " + e.getMessage());
//        }
//        return null;
//    }
//
//    public static String captureScreenshotAsBase64(WebDriver driver) {
//        try {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            String base64Screenshot = screenshot.getScreenshotAs(OutputType.BASE64);
//            System.out.println("Screenshot taken successfully.");
//            return base64Screenshot;
//        } catch (Exception e) {
//            System.out.println("An error occurred while taking screenshot: " + e.getMessage());
//            return null;
//        }
//    }

    public String getScreenshotPath(String testcaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destFile =  System.getProperty("user.dir") + "//reports" + testcaseName + ".png";
        FileUtils.copyFile(source, new File(destFile));
        return destFile;
    }

}

