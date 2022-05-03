package com.uitestpractice.test;

import com.uitestpractice.pages.FormPage;
import com.uitestpractice.pages.MainPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class FormPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();
        CommonMethods.click(mainPage.formLink);
        FormPage formPage = new FormPage();

        CommonMethods.sendKeys(formPage.firstName, "Anton");
        CommonMethods.sendKeys(formPage.lastName, "Anokhin");
        CommonMethods.takingScreenshot("screenshots/Uitest/firstAndLastName.png");

        CommonMethods.selectingRadioBtn(formPage.martialStatus, "Married");
        CommonMethods.selectingRadioBtn(formPage.martialStatus, "Single");
        CommonMethods.selectingRadioBtn(formPage.martialStatus, "Divorced");
        CommonMethods.takingScreenshot("screenshots/Uitest/radioButtons.png");


        CommonMethods.selectingSpecificCheckBox(formPage.hobby, "dance");
        CommonMethods.selectingSpecificCheckBox(formPage.hobby, "read");
        CommonMethods.selectingSpecificCheckBox(formPage.hobby, "cricket");
        CommonMethods.takingScreenshot("screenshots/Uitest/selectedCheckboxes.png");
        CommonMethods.deselectAllCheckboxes(formPage.hobby);

        CommonMethods.selectingDD(formPage.countryDD, "Canada");
        CommonMethods.takingScreenshot("screenshots/Uitest/selectedDD.png");

        CommonMethods.click(formPage.datepicker);
        CommonMethods.dataPickerSelection(formPage.dobMonth, formPage.dobYear, formPage.dobDates, "Jun", "1984", "26");
        CommonMethods.takingScreenshot("screenshots/Uitest/dob.png");

        CommonMethods.sendKeys(formPage.phoneNumber, "233223234324");
        CommonMethods.takingScreenshot("screenshots/Uitest/phoneNumber.png");

        CommonMethods.sendKeys(formPage.userName, "someusername");
        CommonMethods.takingScreenshot("screenshots/Uitest/username.png");

        CommonMethods.sendKeys(formPage.email, "email@email.com");
        CommonMethods.takingScreenshot("screenshots/Uitest/email.png");

        CommonMethods.scrollingToSpecificElement(formPage.userName);
        CommonMethods.sendKeys(formPage.aboutYourself, "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        CommonMethods.takingScreenshot("screenshots/Uitest/about.png");

        CommonMethods.sendKeys(formPage.password, "asl;kdfjakjf");
        CommonMethods.takingScreenshot("screenshots/Uitest/password.png");

        CommonMethods.click(formPage.submitBtn);
        CommonMethods.takingScreenshot("screenshots/Uitest/submit.png");

        BaseClass.tearDown();
    }
}
