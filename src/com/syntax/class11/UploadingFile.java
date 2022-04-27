package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingFile {
    static String url = "https://the-internet.herokuapp.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement fileUploadlink = driver.findElement(By.linkText("File Upload"));
        fileUploadlink.click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/sebvettal/Desktop/Book1.xlsx");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }
}
