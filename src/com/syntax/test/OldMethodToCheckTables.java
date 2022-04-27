package com.syntax.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OldMethodToCheckTables {
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

        WebElement pimLnk = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimLnk.click();
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='resultTable']//th"));
        for (WebElement tableColumn : tableColumns) {
            String text = tableColumn.getText();
            System.out.println(text);
        }
        for (int i = 0; i < tableColumns.size(); i++) {
            String text = tableColumns.get(i).getText();
            if (text.equals("Id")) {
                List<WebElement> IdColData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[" + (i + 1) + "]"));
                for (int j = 1; j < IdColData.size(); j++) {
                    String id = IdColData.get(j).getText();
                    if (id.equals("17116714")) {
                        String lastName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + j + "]/td[" + (i + 2) + "]")).getText();
                        System.out.println("First name for id 17116714 holder is " + lastName);
                        break;
                    }
                }
            }
        }
    }
}
