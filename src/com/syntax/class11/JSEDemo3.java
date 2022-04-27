package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEDemo3 {
    public static String  url = "https://www.google.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.linkText("Privacy")).click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.amazon.com');");
        driver.get(url); // refreshing the main page

    }
}