package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandlingDynamicTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> dynamicTable = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
        for (int i = 1; i < dynamicTable.size(); i++) {
            String rowText = dynamicTable.get(i).getText();
            System.out.println(rowText);

            List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]"));
            if(rowText.contains("Bob Feather")) {
                checkBoxes.get(i-1).click();
            }
        }

    }
}