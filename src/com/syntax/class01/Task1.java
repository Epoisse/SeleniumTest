package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver amazon=new ChromeDriver();
        amazon.get("https://www.amazon.com/");
        System.out.println(amazon.getTitle());
        System.out.println(amazon.getCurrentUrl());
        amazon.quit();
    }
}
