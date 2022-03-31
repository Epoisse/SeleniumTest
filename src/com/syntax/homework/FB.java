package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Epoisses");
        driver.findElement(By.name("lastname")).sendKeys("Camamberovich");
        driver.findElement(By.name("reg_email__")).sendKeys("214769314698231");
        driver.findElement(By.id("password_step_input")).sendKeys("Epoisses123@");
        driver.findElement(By.name("websubmit")).click();
        driver.findElement(By.cssSelector("._8ien ._8idr")).click();
        driver.quit();
    }
}
