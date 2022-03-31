package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FacebookDD {
    static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createNewAccButton = driver.findElement(By.linkText("Create new account"));
        createNewAccButton.click();
        Thread.sleep(1000);

        WebElement monthDD = driver.findElement(By.id("month"));
        Select select = new Select(monthDD);
        List<WebElement> monthOptions = select.getOptions();
        if (monthOptions.size() == 12) {
            System.out.println("month dropdown test is passes. It has 12 options");
        } else {
            System.out.println("month dropdown test is failed. It has " + monthOptions.size() + " instead of 12");
        }

        WebElement daysDD = driver.findElement(By.id("day"));
        Select select1 = new Select(daysDD);
        List<WebElement> daysOptions = select1.getOptions();
        if (daysOptions.size() == 31) {
            System.out.println("days dropdown test is passes. It has 31 options");
        } else {
            System.out.println("days dropdown test is failed. It has " + daysOptions.size() + " instead of 31");
        }

        WebElement yearsDD = driver.findElement(By.id("year"));
        Select select2 = new Select(yearsDD);
        List<WebElement> yearsOptions = select2.getOptions();
        if (daysOptions.size() == 115) {
            System.out.println("years dropdown test is passes. It  has 115 options");
        } else {
            System.out.println("years dropdown test is failed. It has " + yearsOptions.size() + " instead of 115");
        }

        select.selectByVisibleText("Jun");
        select1.selectByVisibleText("26");
        select2.selectByVisibleText("1984");

        driver.quit();
    }
}
