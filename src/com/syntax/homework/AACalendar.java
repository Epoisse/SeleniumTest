package com.syntax.homework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AACalendar {
    static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departDate = driver.findElement(By.className("ui-datepicker-trigger"));
        departDate.click();

        WebElement departMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        WebElement nextBtn = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        String departMonthText = departMonth.getText();

        while (!departMonthText.equals("June")) {
            nextBtn.click();
            departMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            departMonthText = departMonth.getText();
            nextBtn = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        }

        List<WebElement> departDates = driver.findElements(By.xpath("(//table[@class = 'ui-datepicker-calendar'])[1]/tbody/tr/td"));
        for (WebElement depDates :
                departDates) {
            String depDatesText = depDates.getText();
            if (depDatesText.equalsIgnoreCase("26")) {
                depDates.click();
                break;
            }
        }

        WebElement returnDate = driver.findElement(By.xpath("//label[@for='aa-returningFrom']/following-sibling::button"));
        returnDate.click();

        WebElement returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
        String returnMonthText = returnMonth.getText();
        while (!returnMonthText.equals("July")) {
            nextBtn.click();
            returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
            returnMonthText = returnMonth.getText();
            nextBtn = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        }

        List<WebElement> returnDates = driver.findElements(By.xpath("(//table[@class = 'ui-datepicker-calendar'])[2]/tbody/tr/td"));
        for (WebElement repDates :
                returnDates) {
            String depDatesText = repDates.getText();
            if (depDatesText.equalsIgnoreCase("1")) {
                repDates.click();
                break;
            }
        }

        WebElement destinationAirport = driver.findElement(By.xpath("//label[@for='reservationFlightSearchForm.destinationAirport']"));
        destinationAirport.sendKeys("ord", Keys.ENTER);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("screenshots/AA/search.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
