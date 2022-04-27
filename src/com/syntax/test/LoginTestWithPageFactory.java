package com.syntax.test;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class LoginTestWithPageFactory {
    public static void main(String[] args) {
        BaseClass.openWithSpecificUrl("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        LoginPageWithPageFactory loginPageWithPageFactory = new LoginPageWithPageFactory();
        DashboardPage dashboardPage = new DashboardPage();
        loginPageWithPageFactory.username.sendKeys("Tester");
        loginPageWithPageFactory.password.sendKeys("test");
        loginPageWithPageFactory.loginBtn.click();

        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/HRM/dashboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String welcomeText = dashboardPage.welcomeAdmin.getText();
        System.out.println(welcomeText);

        BaseClass.closeBrowser();
    }
}
