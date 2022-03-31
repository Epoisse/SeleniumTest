package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parabank {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Anton");
        driver.findElement(By.id("customer.lastName")).sendKeys("Anokhin");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Liberty ave");
        driver.findElement(By.id("customer.address.city")).sendKeys("Free City");
        driver.findElement(By.id("customer.address.state")).sendKeys("Independent state");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("44455544444");
        driver.findElement(By.id("customer.ssn")).sendKeys("2457084");
        driver.findElement(By.id("customer.username")).sendKeys("randomusername");
        driver.findElement(By.id("customer.password")).sendKeys("randompassword");
        driver.findElement(By.id("repeatedPassword")).sendKeys("randompassword");
        driver.findElement(By.className("button")).click();
        driver.quit();

    }

}
