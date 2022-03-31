package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.syntax.homework.FacebookDD.url;

public class FacebookSignUpForm {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createNewAccButton = driver.findElement(By.linkText("Create new account"));
        createNewAccButton.click();

        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Donald");


        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Baiden");


        WebElement numberOrEmail = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        numberOrEmail.sendKeys("3475037708");


        WebElement password = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        password.sendKeys("donaldbaiden123");


        WebElement monthDD = driver.findElement(By.id("month"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jun");


        WebElement daysDD = driver.findElement(By.id("day"));
        Select select1 = new Select(daysDD);
        select1.selectByVisibleText("26");


        WebElement yearsDD = driver.findElement(By.id("year"));
        Select select2 = new Select(yearsDD);
        select2.selectByVisibleText("1984");


        List<WebElement> radios = driver.findElements(By.cssSelector("input[name='sex']"));
        for (WebElement rads : radios) {
            String radiosText = rads.getAttribute("value");
            if (radiosText.equals("2")) {
                rads.click();
                break;
            }
        }

        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUpButton.click();

        driver.quit();

    }
}
