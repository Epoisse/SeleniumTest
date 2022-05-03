package com.uitestpractice.test;

import com.uitestpractice.pages.MainPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class MainPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();

        //Drag and Drop
        CommonMethods.dragAndDrop(mainPage.dragElement, mainPage.target);
        CommonMethods.takingScreenshot("screenshots/Uitest/dragAndDrop.png");

        //Double click
        CommonMethods.doubleClick(mainPage.doubleClkBtn);
        CommonMethods.switchToAlertAndAccept();
        CommonMethods.takingScreenshot("screenshots/Uitest/doubleClick.png");

        //Iframe handling
        CommonMethods.switchToSpecificIframe(0);
        CommonMethods.sendKeys(mainPage.iframeEnterName, "Anton");
        CommonMethods.takingScreenshot("screenshots/Uitest/iframeName.png");

        BaseClass.tearDown();
    }
}
