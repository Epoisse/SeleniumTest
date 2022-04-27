package net.syntaxtechs.hrm.utils;

import net.syntaxtechs.hrm.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommonMethods extends BaseClass {
    public static void sendText (WebElement element, String input) {
        element.clear();
        element.sendKeys(input);
    }
    public static void takingScreenShots (String path) {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlighting (WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='black'", element);
    }


}
