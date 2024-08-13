package com.QM.pageObjects.android;

import com.QM.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class InBuiltApp extends AndroidActions {
    private AndroidDriver driver;

    public InBuiltApp(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gallery\")")
    private WebElement GalleryIconBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Camera\")")
    private WebElement CameraBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\")")
    private List<WebElement> ImagesList;


    public void totalImagesList() {
        int ImagesCount = ImagesList.size();
//            double totalSum =0;
        System.out.println("Images present Count :" + ImagesCount);
        WebElement el = ImagesList.get(3);
        el.click();
    }

    public void clickGalleryBtn() {
        GalleryIconBtn.click();
    }

    public void getCameraBtn() {
        CameraBtn.click();
    }


    public boolean swipeImages() {
        try {
            WebElement pageIndicator = driver.findElement(By.xpath("new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(0)"));
            String pageString = pageIndicator.getAttribute("value");
            int length = pageString.length();
            String count_string = pageString.substring(length - 2, length).trim();
            int count = Integer.parseInt(count_string);
//            int count = ImagesList.size();
            System.out.println("AB" +count);
            System.out.println("Number of Image available to Swipe: " + count);
            for (int i = 0; i <= count; i++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                HashMap<String, String> scrollObject = new HashMap<String, String>();
                System.out.println("JB");
                scrollObject.put("direction", "right");
                js.executeScript("mobile: scroll", scrollObject);
                System.out.println("Swipe Successfully 2");
            }
            System.out.println("Swipe Successfully");
        } catch (Exception e) {
            System.out.println("Image swipe was not successfull");
        }
        return false;
    }
    public void AndroidKeyActions(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}




