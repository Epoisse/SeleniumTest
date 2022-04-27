package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEDemo2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollBy(0,-1000)");

        WebElement toTopBtn= driver.findElement(By.className("navFooterBackToTopText"));
        js.executeScript("arguments[0].scrollIntoView(true)", toTopBtn);
        toTopBtn.click();
    }
}
