package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandling {
        /*
        navigating to delta
        choosing departure and return dates
         */
    static String url = "http://delta.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();

        WebElement month = driver.findElement(By.className("dl-datepicker-month-0"));
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        String dMonth = month.getText();

        while (!dMonth.equals("August")) {
            nextButton.click();
            dMonth = month.getText();
        }

        List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
        for (WebElement departDate : departDates) {
            if (departDate.getText().equals("13")) {
                departDate.click();
                break;
            }
        }

        WebElement month2 = driver.findElement(By.className("dl-datepicker-month-1"));
        String dMonth2 = month2.getText();
        while (!dMonth2.equals("November")) {
            nextButton.click();
            dMonth2 = month2.getText();
        }
        List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
        for (WebElement returningDate : returnDates) {
            if (returningDate.getText().equals("30")) {
                returningDate.click();
                break;
            }
        }
        WebElement doneButton= driver.findElement(By.className("donebutton"));
        doneButton.click();
    }
}
