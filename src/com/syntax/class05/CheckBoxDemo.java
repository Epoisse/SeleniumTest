package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxDemo {

    static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // locating checkboxes and storing them to the list
        List<WebElement> radios= driver.findElements(By.cssSelector("input[class = 'cb1-element']"));
        int size=radios.size();
        System.out.println(size);

        for (WebElement rads:
             radios) {
            String radiosChecks=rads.getAttribute("value");
            if(radiosChecks.equals("Option-2")) {
                rads.click();
                break;
            }
        }

    }
}
