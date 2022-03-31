package com.syntax.homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertSyntax {
    static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement alertBox=driver.findElement(By.cssSelector("button[class = 'btn btn-default']"));
        WebElement confirmBox=driver.findElement(By.cssSelector("button[class = 'btn btn-default btn-lg']"));
        WebElement promptBox=driver.findElement(By.xpath("//button[text () ='Click for Prompt Box']"));

        alertBox.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();


        confirmBox.click();
        Thread.sleep(1000);
        alert.dismiss();

        promptBox.click();
        Thread.sleep(1000);
        promptBox.clear();
        Thread.sleep(1000);
        promptBox.sendKeys("usahfiuoo");
        alert.accept();

        Thread.sleep(1000);
        driver.quit();
    }
}
