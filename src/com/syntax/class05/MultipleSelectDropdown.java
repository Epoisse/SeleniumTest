package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TransferQueue;

public class MultipleSelectDropdown {
    static String url = "https://www.syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement statesDD = driver.findElement(By.id("multi-select"));
        Select select = new Select(statesDD);
        boolean isMultiple = select.isMultiple();

        if (isMultiple) {
            List<WebElement> options = select.getOptions();
            for (WebElement option :
                    options) {
                String optionText = option.getText();
                select.selectByVisibleText(optionText);
                Thread.sleep(1000);
            }
        }
        select.deselectByIndex(5);
        select.deselectAll();

    }
}
