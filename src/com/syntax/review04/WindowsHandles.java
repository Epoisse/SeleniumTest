package com.syntax.review04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandles {

    static String url = "https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement privacyLink = driver.findElement(By.xpath("//a[text()='Privacy']"));
        WebElement termsLink = driver.findElement(By.xpath("//a[text()='Terms']"));
        helpBtn.click();
        privacyLink.click();
        termsLink.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPageHandle = driver.getWindowHandle();

        Set<String> windowsHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowsHandles.iterator();
        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!handle.equals(mainPageHandle)) {
                driver.switchTo().window(handle);
                String title = driver.getTitle();
                if (title.equalsIgnoreCase("Privacy Policy – Privacy & Terms – Google")) {
                    System.out.println("Baaam");
                    break;
                }
            }
        }
    }
}