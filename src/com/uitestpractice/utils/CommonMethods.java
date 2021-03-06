package com.uitestpractice.utils;

import com.uitestpractice.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommonMethods extends BaseClass {

    public static Actions action;

    public static void takingScreenshot(String path) {
        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDrop(WebElement draggable, WebElement target) {
        action = new Actions(driver);
        action.dragAndDrop(draggable, target).perform();
    }

    public static void doubleClick(WebElement element) {
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public static void switchToAlertAndAccept() {
        driver.switchTo().alert().accept();
    }

    public static void promptAlertSendkeysAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static void switchToSpecificIframe(int iframe) {
        driver.switchTo().frame(iframe);
    }

    public static void sendKeys(WebElement element, String keys) {
        element.clear();
        element.sendKeys(keys);
    }

    public static void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void actionClick(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element);
    }

    public static void selectElementFromTable(List<WebElement> table, String element) {
        for (WebElement tab :
                table) {
            if (tab.getText().equalsIgnoreCase(element)) {
                tab.click();
                break;
            }
        }
    }

    public static void selectAllElementsFromTable(WebElement element, List<WebElement> table) {
        for (WebElement tab :
                table) {
            CommonMethods.scrollingToBottom();
            element.click();
            tab.click();
        }
    }

    public static void deleteUserFromTableByName(List<WebElement> tableRows, WebElement deleteConfBtn, String user) {
        for (int i = 0; i < tableRows.size(); i++) {
            if (tableRows.get(i).getText().contains(user)) {
                driver.findElement(By.xpath("(//button[text()='DELETE'])[" + i + "]")).click();
                break;
            }
        }
        explicitWaitElementIsPresent(deleteConfBtn);
        deleteConfBtn.click();
    }

    public static void explicitWaitElementIsPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void verifyingTextIsPresent(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("The text is displayed");
        } else {
            System.out.println("The text is not displayed");
        }
    }

    public static void verifyingText(WebElement element, String text) {
        if (element.getText().equals(text)) {
            System.out.println("text message is verified");
        } else System.out.println("text message does not match. The text message is: " + element.getText());
    }

    public static void selectingRadioBtn(List<WebElement> radios, String buttonText) {
        for (WebElement rad :
                radios) {
            if (rad.getText().equalsIgnoreCase(buttonText)) {
                if (!rad.isSelected()) {
                    rad.click();
                }
            }
        }
    }

    public static void selectingSpecificCheckBox(List<WebElement> checkboxes, String btnValue) {
        for (WebElement check :
                checkboxes) {
            if (check.getAttribute("value").equalsIgnoreCase(btnValue)) {
                if (!check.isSelected()) {
                    check.click();
                }
            }
        }
    }

    public static void deselectAllCheckboxes(List<WebElement> checkboxes) {
        for (WebElement check :
                checkboxes) {
            if (check.isSelected()) {
                check.click();
            }
        }
    }

    public static void selectingDD(WebElement dd, String country) {
        Select select = new Select(dd);
        select.selectByVisibleText(country);
    }

    public static void selectingAllOptionsMultiDD(WebElement dd) {
        Select select = new Select(dd);
        List<WebElement> options = select.getOptions();
        for (WebElement option :
                options) {
            String optionText = option.getText();
            select.selectByVisibleText(optionText);
        }
        select.deselectByIndex(2);
        select.deselectAll();
    }

    public static void dataPickerSelection(WebElement monthDD, WebElement yearDD, List<WebElement> dates, String month, String year, String date) {
        Select select = new Select(monthDD);
        select.selectByVisibleText(month);

        Select select1 = new Select(yearDD);
        select1.selectByVisibleText(year);

        for (WebElement dat :
                dates) {
            if (dat.getText().equalsIgnoreCase(date)) {
                dat.click();
            }
        }
    }

    public static void scrollingToSpecificElement(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollingToBottom() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void windowHandling() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindow = null;
        String childWindow = null;
        while (iterator.hasNext()) {
            mainWindow = iterator.next();
            childWindow = iterator.next();
        }
        driver.switchTo().window(childWindow);
        driver.close();
        driver.switchTo().window(mainWindow);
    }
}
