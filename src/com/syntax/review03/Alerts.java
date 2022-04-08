package com.syntax.review03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick=\"myAlertFunction()\"]"));
        simpleAlert.click();
        // handling the alert

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement jsalert= driver.findElement(By.xpath("//button[@onclick=\"myPromptFunction()\"]"));
        jsalert.click();
        driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
    }
}
