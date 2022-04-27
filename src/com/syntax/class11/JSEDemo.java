package com.syntax.class11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSEDemo {
    static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='red'", username);
        js.executeScript("arguments[0].style.backgroundColor='purple'", password);
        js.executeScript("arguments[0].click()", loginButton);
    }
}
