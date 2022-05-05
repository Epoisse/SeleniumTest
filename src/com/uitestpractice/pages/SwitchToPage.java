package com.uitestpractice.pages;

import com.uitestpractice.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToPage extends BaseClass {

    public static int iFrame = 0;

    //Alerts
    public @FindBy(id = "alert")
    WebElement alertBtn;

    public @FindBy(id = "confirm")
    WebElement confirmBtn;

    public @FindBy(id = "prompt")
    WebElement promptBtn;

    public @FindBy(xpath = "//button[@data-target ='#myModal']")
    WebElement launchModalBtn;

    public @FindBy(xpath = "//button[text()='Ok']")
    WebElement modalAlertOkBtn;

    public @FindBy(id = "basicAuthentication")
    WebElement authenticationBtn;

    public @FindBy(id = "demo")
    WebElement alertMessage;

    //iFrame
    public @FindBy(id = "name")
    WebElement nameBox;

    //window links
    public @FindBy(linkText = "uitestpractice.com")
    WebElement siteLink;

    public @FindBy(partialLinkText = "new window")
    WebElement newWindowLink;

    public SwitchToPage() {
        PageFactory.initElements(driver, this);
    }
}
