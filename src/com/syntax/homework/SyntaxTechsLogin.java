package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SyntaxTechsLogin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[contains(@id, 'Login')]"));
        userName.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        loginButton.click();
        WebElement syntaxLogo = driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']"));
        if (syntaxLogo.isDisplayed()) {
            System.out.println("logo is displayed");
        } else {
            System.out.println("logo is not displayed");
        }
        driver.quit();
    }
}
