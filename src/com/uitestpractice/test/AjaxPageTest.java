package com.uitestpractice.test;

import com.uitestpractice.pages.AjaxPage;
import com.uitestpractice.pages.HomePage;
import com.uitestpractice.pages.MainPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class AjaxPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");

        MainPage mainPage = new MainPage();
        AjaxPage ajaxPage = new AjaxPage();
        BaseClass.driver.manage().window().maximize();
        CommonMethods.click(mainPage.ajaxMenuLink);
        CommonMethods.click(ajaxPage.ajaxInnerLink);
        CommonMethods.explicitWaitElementIsPresent(ajaxPage.getAjaxLinkText);
        CommonMethods.verifyingTextIsPresent(ajaxPage.getAjaxLinkText);
        CommonMethods.takingScreenshot("screenshots/Uitest/ajaxText.png");

        BaseClass.tearDown();
    }
}
