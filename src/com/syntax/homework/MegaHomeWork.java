package com.syntax.homework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MegaHomeWork {
    public static String url = "http://www.uitestpractice.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //1. Drag and Drop
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, target).perform();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File fileSrc = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(fileSrc, new File("screenshots/Uitest/dragAndDrop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Double click
        WebElement dblClk = driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(dblClk).perform();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        TakesScreenshot ts1 = (TakesScreenshot) driver;
        File fileSrc1 = ts1.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileSrc1, new File("screenshots/Uitest/doubleClick.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3. Iframe handling
        driver.switchTo().frame(0);
        WebElement enterYourNameField = driver.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
        enterYourNameField.clear();
        enterYourNameField.sendKeys("Anton");

        TakesScreenshot ts2 = (TakesScreenshot) driver;
        File fileSrc2 = ts2.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileSrc2, new File("screenshots/Uitest/iframeName.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();

        //4. Home. Deleting user from the table
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tr"));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getText().contains("Dwight")) {
                driver.findElement(By.xpath("(//button[text()='DELETE'])[" + i + "]")).click();
                break;
            }
        }
        WebElement deleteConfirmationBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        deleteConfirmationBtn.click();

        TakesScreenshot ts3 = (TakesScreenshot) driver;
        File fileSrc3 = ts3.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileSrc3, new File("screenshots/Uitest/deletingUser.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5. Ajax link
        driver.manage().window().maximize();
        WebElement ajaxMenuLink = driver.findElement(By.linkText("AjaxCall"));
        ajaxMenuLink.click();

        WebElement ajaxInnerLink = driver.findElement(By.partialLinkText("Ajax link"));
        ajaxInnerLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ContactUs")));
        WebElement ajaxLinkText = driver.findElement(By.cssSelector("div.ContactUs"));
        if (ajaxLinkText.isDisplayed()) {
            System.out.println("The ajax text is displayed");
        } else {
            System.out.println("The ajax text is not displayed");
        }

        TakesScreenshot ts4 = (TakesScreenshot) driver;
        File fileSrc4 = ts4.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileSrc4, new File("screenshots/Uitest/ajaxText.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
