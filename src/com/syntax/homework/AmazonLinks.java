package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonLinks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int counter = 0;
        for (WebElement a : allLinks
        ) {
            String linkText = a.getText();
            if (!linkText.isEmpty()) {
                counter++;
                System.out.println(a.getText() + " " + a.getAttribute("href"));
            }
        }
        System.out.println("The amount of links with text is " + counter + " of " + allLinks.size());
        driver.quit();
    }
}
