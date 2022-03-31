package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorElements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //2. Create an object
        WebDriver driver = new ChromeDriver();
        driver.get("http://fb.com");
        driver.findElement(By.id("email")).sendKeys("syntax@adfadf.com");
        driver.findElement(By.id("pass")).sendKeys("whatever");
        driver.findElement(By.name("login")).click();
        //driver.findElement(By.linkText("Forgot password?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();
    }
}
