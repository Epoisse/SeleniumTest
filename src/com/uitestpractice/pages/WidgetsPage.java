package com.uitestpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WidgetsPage {

    @FindBy (xpath = "//input[@type='file']")
    WebElement chooseFileBtn;

    @FindBy (xpath = "//input[@value='Upload']")
    WebElement uploadBtn;
}
