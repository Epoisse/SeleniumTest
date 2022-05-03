package com.uitestpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchToPage {

    public static int iFrame=1;

    //Alerts
    @FindBy(id = "alert")
    WebElement alertBtn;

    @FindBy(id = "confirm")
    WebElement confirmBtn;

    @FindBy(id = "prompt")
    WebElement promptBtn;

    @FindBy(xpath = "//button[@data-target ='#myModal']")
    WebElement launchModalBtn;

    @FindBy(id = "basicAuthentication")
    WebElement authenticationBtn;

    //iFrame
    @FindBy(id = "name")
    WebElement nameBox;

    //window links
    @FindBy(linkText = "uitestpractice.com")
    WebElement siteLink;

    @FindBy(partialLinkText = "new window")
    WebElement newWindowLink;

}
