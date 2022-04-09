package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebTableDemo {
    static String url = "https://demoqa.com/browser-windows"; //needed url update

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        List<WebElement> tableData=driver.findElements(By.xpath("//table[@id='task-table]/tbody/tr"));
        Iterator<WebElement> iterator=tableData.iterator();
        while (iterator.hasNext()) {
            WebElement elements=iterator.next();
            String rowText= elements.getText();
            System.out.println(rowText);
        }
        System.out.println("-------------------------------");

        List<WebElement> columnsData =driver.findElements(By.xpath("\"//table[@id='task-table]/tbody/tr/th\""));
        for (WebElement colData: columnsData) {
            String colText=colData.getText();
            System.out.println(colText);
        }

    }
}
