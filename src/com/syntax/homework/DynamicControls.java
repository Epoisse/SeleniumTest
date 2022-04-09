package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {
    /*
    go to https://the-internet.herokuapp.com/dynamic_controls
    click on checkbox and click on remove
    verify the text
    click on enable
    verify the textbox is enabled
    enter text and click disable
    verify the textbox is disabled
     */
    static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement addRemoveButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        WebElement enableDisableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        checkBox.click();
        addRemoveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        WebElement message = driver.findElement(By.cssSelector("p#message"));
        if (message.getText().equals("It's gone!")) {
            System.out.println("Element has been removed");
        } else System.out.println("TEST FAILED! Element has not been removed");

        enableDisableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        if (textBox.isEnabled()) {
            System.out.println("Textbox is enabled");
            textBox.sendKeys("It's pretty hot outside");
            enableDisableButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
            WebElement message1 = driver.findElement(By.cssSelector("p#message"));
            if (message1.getText().equals("It's disabled!")) {
                System.out.println("Textbox has been disabled");
                System.out.println("Test passed");
            } else System.out.println("TEST FAILED! Textbox has not been disabled");
        } else System.out.println("TEST FAILED! Textbox is disabled");

        driver.quit();
    }
}
