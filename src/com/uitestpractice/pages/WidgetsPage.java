package com.uitestpractice.pages;

import com.uitestpractice.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage extends BaseClass {

    public @FindBy(xpath = "//input[@type='file']")
    WebElement chooseFileBtn;

    public @FindBy(xpath = "//input[@value='Upload']")
    WebElement uploadBtn;

    public @FindBy(css = "div.ContactUs")
    WebElement confirmationMsg;

    public WidgetsPage() {
        PageFactory.initElements(driver, this);
    }
}
