package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StudentsContact {

    static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement linkAjax = driver.findElement(By.xpath("//a[contains(text(),'Ajax link')]"));
        linkAjax.click();
        WebElement textAjaxLink = driver.findElement(By.xpath("//div[@class='ContactUs']/p"));
        System.out.println(textAjaxLink.getText());

        driver.quit();
    }
}
