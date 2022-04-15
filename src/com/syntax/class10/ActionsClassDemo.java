package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {
    /*
    navigate to amazon and hover over cursor onto account & list
     */

        static String url = "http://amazon.com";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            WebElement accountList= driver.findElement(By.id("nav-link-accountList"));
            Actions action=new Actions(driver);
            action.moveToElement(accountList).perform();
    }
}
