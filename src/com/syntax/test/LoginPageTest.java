package com.syntax.test;

import com.syntax.pages.LoginPageClass;
import com.syntax.testbase.BaseClass;

public class LoginPageTest {
    public static void main(String[] args) {
        BaseClass.openWithSpecificUrl("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        LoginPageClass loginPage = new LoginPageClass();
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.loginButton.click();
        BaseClass.closeBrowser();
    }
}
