package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMSApplicationNegativeLogin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.xpath("//input[@name = 'txtUsername']"));
        userName.sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("span#spanMessage"));
        if (errorMessage.isDisplayed()) {
            if (errorMessage.getText().equals("Password cannot be empty")) {
                System.out.println("Error message is verified");
            } else {
                System.out.println("Error message is not correct");
            }
        } else System.out.println("Error message is not displayed");
        driver.quit();
    }
}
