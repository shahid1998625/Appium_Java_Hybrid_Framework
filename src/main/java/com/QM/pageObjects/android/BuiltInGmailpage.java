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

public class BuiltInGmailpage extends AndroidActions {
    private AndroidDriver driver;

    public BuiltInGmailpage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Gmail']")
    private WebElement GmailIconBtn;

    @AndroidFindBy(accessibility = "Compose")
    private WebElement ComposeBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id = 'com.google.android.gm:id/peoplekit_autocomplete_chip_group']/android.widget.EditText")
    private WebElement ToBtn;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id = 'com.google.android.gm:id/peoplekit_listview_flattened_row']")
    private WebElement sujjestionsBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.google.android.gm:id/subject']")
    private WebElement SubjectBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Compose email\")")
    private WebElement ComposeEmailText;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private WebElement NavdrawBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sent\")")
    private WebElement SentBtnNav;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\")")
    private List<WebElement> ImagesList;

    @AndroidFindBy(id = "com.google.android.gm:id/send")
    private WebElement sendBtn;

    public void totalImagesList() {
        int ImagesCount = ImagesList.size();
//            double totalSum =0;
        System.out.println("Images present Count :" + ImagesCount);
        WebElement el = ImagesList.get(3);
        el.click();
    }

    public void clickGmailappBtn() throws InterruptedException {
        GmailIconBtn.click();
        Thread.sleep(5000);
    }
    public void clickonComposeBtn() throws InterruptedException {
        ComposeBtn.click();
        Thread.sleep(3000);
    }

    public void clickonToBtn(String em) throws InterruptedException {
        ToBtn.sendKeys(em);
        sujjestionsBtn.click();
        Thread.sleep(2000);
    }

    public void enterSubject(String subject) throws InterruptedException {
        SubjectBtn.sendKeys(subject);
        Thread.sleep(2000);
    }

    public void entermailText(String mailText) throws InterruptedException {
        ComposeEmailText.sendKeys(mailText);
        Thread.sleep(2000);
    }

    public void clickSendEmailBtn(){
        sendBtn.click();
    }
    public void clickOnAndroidBackBtn(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void clickNavigationBtn(){
        NavdrawBtn.click();
    }
    public void clickonSentBtn(){
        SentBtnNav.click();
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
}




