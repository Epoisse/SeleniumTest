package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class DemoqaWindows {

    static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        String mainWindowHandle = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.cssSelector("button#tabButton"));
        WebElement newWindowButton = driver.findElement(By.xpath("//button[text() = 'New Tab']"));
        WebElement newWindowMessage = driver.findElement(By.xpath("//button[contains(text(), 'Window Message')]"));
        newTabButton.click();
        newWindowButton.click();
        newWindowMessage.click();

        Set<String> windowsHanding = driver.getWindowHandles();
        Iterator<String> iterator = windowsHanding.iterator();
        while (iterator.hasNext()) {
            String handle = iterator.next();
            driver.switchTo().window(handle);
            if (!handle.equals(mainWindowHandle)) {
                String bodyText = driver.findElement(By.cssSelector("body")).getText();
                System.out.println("Body text: " + bodyText);
            }
            String title = driver.getTitle();
            if (!title.isEmpty()) {
                System.out.println("The title is: " + title);
            } else System.out.println("Title is empty");

        }
        driver.quit();
    }
}
