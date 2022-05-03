package com.uitestpractice.test;

import com.uitestpractice.pages.HomePage;
import com.uitestpractice.pages.MainPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class HomePageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");

        MainPage mainPage=new MainPage();
        HomePage homePage=new HomePage();
        CommonMethods.click(mainPage.homeLink);

        CommonMethods.deleteUserFromTableByName(homePage.rows, homePage.deleteConfirmationBtn, "Alan");
        CommonMethods.takingScreenshot("screenshots/Uitest/deletingUser.png");

        BaseClass.tearDown();
    }
}
