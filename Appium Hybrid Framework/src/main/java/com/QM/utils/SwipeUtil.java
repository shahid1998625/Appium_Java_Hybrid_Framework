package com.QM.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class SwipeUtil {

    private AndroidDriver driver;

    public SwipeUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public void swipeLeftToRight() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = (int) (dimension.width * 0.10);
        int endX = (int) (dimension.width * 0.90);
        int y = dimension.height / 2;

        swipe(startX, y, endX, y);
    }

    public void swipeRightToLeft() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = (int) (dimension.width * 0.90);
        int endX = (int) (dimension.width * 0.10);
        int y = dimension.height / 2;

        swipe(startX, y, endX, y);
    }

    private void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }
}
