package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeSyntax {

    /*
    Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
verify enroll today button is enabled
     */

    static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement title = driver.findElement(By.cssSelector("span.gum"));
        if (title.getText().equals("AUTOMATION TESTING PLATFORM BY SYNTAX")) {
            System.out.println("The title is correct");
        } else System.out.println("The title is not correct");

        driver.switchTo().frame(1);
        WebElement enrollTodayButton = driver.findElement(By.cssSelector("div.text-block-2"));
        if (enrollTodayButton.isEnabled()) {
            System.out.println("Enroll today button is enabled");
        } else System.out.println("Enroll today button is disabled");

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
