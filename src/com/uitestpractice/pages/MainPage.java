package com.uitestpractice.pages;

import com.uitestpractice.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends CommonMethods {

    //drag and drop elements
    public @FindBy(xpath = "//div[@id='draggable']")
    WebElement dragElement;

    public @FindBy(css = "div#droppable")
    WebElement target;

    public @FindBy(xpath = "//button[@name='dblClick']")
    WebElement doubleClkBtn;

    //iframe
    public @FindBy(xpath = "//label[text()='Enter your name:']/following-sibling::input")
    WebElement iframeEnterName;

    //menu bar
    public @FindBy(linkText = "Home")
    WebElement homeLink;

    public @FindBy(linkText = "AjaxCall")
    WebElement ajaxMenuLink;

    public @FindBy(linkText = "Form")
    WebElement formLink;

    public @FindBy(id = "image_file")
    WebElement widgetsLink;

    public @FindBy(linkText = "Actions")
    WebElement actionLink;

    public @FindBy(linkText = "Switch to")
    WebElement switchToLink;

    public @FindBy(linkText = "Select")
    WebElement selectLink;

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

}
