package com.uitestpractice.test;

import com.uitestpractice.pages.MainPage;
import com.uitestpractice.pages.SwitchToPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class SwitchToPageTest {
    public static void main(String[] args) throws InterruptedException {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();
        CommonMethods.click(mainPage.switchToLink);

        SwitchToPage switchToPage = new SwitchToPage();

        CommonMethods.click(switchToPage.alertBtn);
        CommonMethods.switchToAlertAndAccept();
        CommonMethods.verifyingText(switchToPage.alertMessage, "You have clicked on ok button in alert window");

        CommonMethods.click(switchToPage.confirmBtn);
        CommonMethods.switchToAlertAndAccept();
        CommonMethods.verifyingText(switchToPage.alertMessage, "You pressed Ok in confirm window");

        CommonMethods.click(switchToPage.promptBtn);
        CommonMethods.promptAlertSendkeysAndAccept("test");
        CommonMethods.verifyingText(switchToPage.alertMessage, "Hello test! How are you today?");

        CommonMethods.click(switchToPage.launchModalBtn);
        CommonMethods.click(switchToPage.modalAlertOkBtn);

        CommonMethods.switchToSpecificIframe(SwitchToPage.iFrame);
        CommonMethods.sendKeys(mainPage.iframeEnterName, "SomeName");
        CommonMethods.switchToDefault();

        CommonMethods.takingScreenshot("screenshots/Uitest/iframeName.png");
        CommonMethods.click(switchToPage.newWindowLink);
        CommonMethods.windowHandling();

        BaseClass.tearDown();

    }
}
