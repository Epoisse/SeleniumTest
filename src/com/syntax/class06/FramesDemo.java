package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
    static String url = "http://uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);
        WebElement iframeTextBox=driver.findElement(By.id("name"));
        iframeTextBox.sendKeys("Batch 12 forever");

        // switching to main page
        driver.switchTo().defaultContent();

        WebElement alertButton=driver.findElement(By.id("alert"));
        alertButton.click();

        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

        driver.switchTo().frame("iframe_a");
        iframeTextBox.clear();
        iframeTextBox.sendKeys("something");

        driver.switchTo().defaultContent();

        WebElement frameElement=driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
        driver.switchTo().frame(frameElement);
        iframeTextBox.clear();
        iframeTextBox.sendKeys("Hold your horses");
    }
}
