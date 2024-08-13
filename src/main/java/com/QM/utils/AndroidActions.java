package com.QM.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class AndroidActions {
    protected static AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        AndroidActions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void longPressActions(WebElement el) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), el.getLocation().getX(), el.getLocation().getY()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(longPress));
    }

    public Double getFormattedAmount(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    public void scrollToText(String text) {
        WebElement countryDropdown = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void waitForElementToAppear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
    }

    public String getScreenshotPath(String testcaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destFile =  System.getProperty("user.dir") + "//reports" + testcaseName + ".png";
        FileUtils.copyFile(source, new File(destFile));
        return destFile;
    }
    public WebElement SwipingFunct(WebElement element){
//        Map<String,Object> param1 = new HashMap<String, Object>();
//        param1.put("direction","left");
//        driver.executeScript("mobile:swipeGesture", param1);
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        return element;

        }
    }



