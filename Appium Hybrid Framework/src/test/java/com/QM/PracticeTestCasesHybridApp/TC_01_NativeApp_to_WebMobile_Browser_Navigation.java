package com.QM.PracticeTestCasesHybridApp;


import com.QM.Base.BaseClass1;
import com.QM.pageObjects.android.FormPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01_NativeApp_to_WebMobile_Browser_Navigation extends BaseClass1 {
    FormPage fp;
    AndroidDriver driver;


    @Test
    public void EcomappTest1() {
        fp = new FormPage(driver);
        fp.setNamefield("Shahid");
        fp.setGender("male");
        fp.setCountryselection("Australia");
        fp.submitForm();
    }


    @Test(dataProvider = "getData")
    public void EcomappTest2(String name, String gender, String country) throws InterruptedException {
        fp.setNamefield(name);
        Thread.sleep(5000);
        fp.setGender(gender);
        fp.setCountryselection(country);
        fp.submitForm();
    }

    @DataProvider()
    public Object[][] getData() throws IOException {
//        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//com//QM//testData//eComm.json");
        return new Object[][]{{"Shahid", "male", "Australia"}, {"Pranjal", "female", "Australia"}};
    }

}

