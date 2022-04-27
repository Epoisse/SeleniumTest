package com.syntax.utils;

import com.syntax.testbase.BaseClass;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass {
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }
}
