package com.uitestpractice.test;

import com.syntax.homework.Main;
import com.uitestpractice.pages.MainPage;
import com.uitestpractice.pages.SelectPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class SelectPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();
        CommonMethods.click(mainPage.selectLink);
        SelectPage selectPage = new SelectPage();

        CommonMethods.selectingDD(selectPage.countryDD, "China");
        CommonMethods.takingScreenshot("screenshots/Uitest/countryDD.png");

        CommonMethods.selectingAllOptionsMultiDD(selectPage.countryMultiDD);
        CommonMethods.takingScreenshot("screenshots/Uitest/multiDD.png");

        CommonMethods.click(selectPage.countriesDDBtn);
        CommonMethods.selectElementFromTable(selectPage.countriesOptions, "China");
        CommonMethods.selectAllElementsFromTable(selectPage.countriesDDBtn, selectPage.countriesOptions);
        CommonMethods.takingScreenshot("screenshots/Uitest/countries.png");

        BaseClass.tearDown();
    }
}
