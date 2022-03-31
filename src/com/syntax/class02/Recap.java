package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {
    public static void main(String[] args) {
        //1.Set propety
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //2. Create an object
        WebDriver driver = new ChromeDriver();
        driver.get("http://fb.com");
        String title = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        if (title.equals(expectedTitle)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is not correct");
        } driver.quit();
    }
}
