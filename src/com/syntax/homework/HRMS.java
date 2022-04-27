package com.syntax.homework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class HRMS {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        userName.sendKeys("Admin");
        //password.sendKeys("Hum@nhrm123");
        loginBtn.click();

        WebElement message = driver.findElement(By.id("spanMessage"));
        String msg = message.getText();
        if (msg.equals("Password cannot be empty")) {
            System.out.println("The message is validated");
        } else {
            System.out.println("The message is not validated");
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("screenshots/HRM/passwordMsgValidation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
/*
TC 1: HRMS blank password validation
Navigate to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Enter valid username and leave password field empty
Click on login button
Verify error message with text “Password cannot be empty” is displayed
Take a screenshot before quitting the browser
* */