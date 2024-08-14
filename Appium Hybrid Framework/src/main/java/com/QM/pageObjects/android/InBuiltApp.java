package com.QM.pageObjects.android;

import com.QM.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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


    public void AndroidKeyActions() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}




