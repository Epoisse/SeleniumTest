package com.syntax.seleniumUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static WebDriver driver;

    public static void openBrowser (String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
    }
}
