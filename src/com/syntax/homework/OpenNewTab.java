package com.syntax.homework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {

    public static String url="https://stackoverflow.com/questions/3951547/java-array-finding-duplicates";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        JavascriptExecutor je=(JavascriptExecutor) driver;
        je.executeScript("window.open(\"https://docs.oracle.com/javase/7/docs/api/java/lang/NullPointerException.html\");");


    }
}
