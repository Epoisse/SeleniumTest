package net.syntaxtechs.hrm.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static String url;
    public static WebDriver driver;

    public static void openChromeBrowser (String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
