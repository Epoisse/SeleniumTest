package com.syntax.homework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HRMCalendar {

    static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        userName.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement leaveButton = driver.findElement(By.linkText("Leave"));
        leaveButton.click();
        WebElement leaveListButton = driver.findElement(By.linkText("Leave List"));
        leaveListButton.click();

        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();


        WebElement monthDD = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jun");

        WebElement yearDD = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select select1 = new Select(yearDD);
        select1.selectByVisibleText("1984");

        List<WebElement> fromData = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement data :
                fromData) {
            String rowText = data.getText();
            if (rowText.contains("20")) {
                data.click();
                break;
            }
        }

        WebElement toCalendar = driver.findElement(By.id("calToDate"));
        toCalendar.click();

        WebElement monthDD1 = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select select2 = new Select(monthDD1);
        select2.selectByVisibleText("Jul");

        WebElement yearDD1 = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select select3 = new Select(yearDD1);
        select3.selectByVisibleText("2020");

        List<WebElement> toData = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement data :
                toData) {
            String rowText = data.getText();
            if (rowText.contains("13")) {
                data.click();
                break;
            }
        }

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));

        for (int i = 1; i < checkboxes.size(); i++) {
            String values = checkboxes.get(i).getAttribute("value");
            if (!checkboxes.get(i).isSelected() && (values.equals("-1") || values.equals("0"))) {
                checkboxes.get(i).click();
            }
            if (checkboxes.get(i).isSelected() && values.equals("1")) {
                checkboxes.get(i).click();
            }
        }


        WebElement subUnitDD = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select select4 = new Select(subUnitDD);
        select4.selectByVisibleText("IT Support");

        WebElement searchBtn = driver.findElement(By.id("btnSearch"));
        searchBtn.click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("screenshots/HRM/calendar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}

