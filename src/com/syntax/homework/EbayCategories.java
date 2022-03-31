package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EbayCategories {

    static String url = "https://www.ebay.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement allCategories = driver.findElement(By.cssSelector("select.gh-sb "));
        Select select = new Select(allCategories);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equalsIgnoreCase("Computers/Tablets & Networking")) {
                option.click();
            }
        }

        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Search']"));
        searchButton.click();


        WebElement compAndTabletsHeader = driver.findElement(By.cssSelector("span.b-pageheader__text"));
        if (compAndTabletsHeader.getText().equals("Computers, Tablets & Network Hardware")) {
            System.out.println("The header is verified");
        } else {
            System.out.println("The header does not match");
        }
        driver.quit();

    }
}
