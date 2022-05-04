package com.uitestpractice.test;

import com.uitestpractice.pages.MainPage;
import com.uitestpractice.pages.WidgetsPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class WidgetsPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();
        CommonMethods.click(mainPage.widgetsLink);
        WidgetsPage widgetPage = new WidgetsPage();
        CommonMethods.sendKeys(widgetPage.chooseFileBtn, "/Users/sebvettal/Desktop/Screen Shot 2022-05-02 at 2.40.37 PM.png");
        CommonMethods.click(widgetPage.uploadBtn);
        CommonMethods.explicitWaitElementIsPresent(widgetPage.confirmationMsg);
        CommonMethods.verifyingText(widgetPage.confirmationMsg, "File Successfully Uploaded");
        CommonMethods.takingScreenshot("screenshots/Uitest/uploadingFile.png");

        BaseClass.tearDown();
    }
}
