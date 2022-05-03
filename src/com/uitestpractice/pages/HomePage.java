package com.uitestpractice.pages;

import com.uitestpractice.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonMethods {


    public @FindBy(xpath = "//table[@class='table']//tr")
    List<WebElement> rows;

    public @FindBy(xpath = "//input[@type='submit']")
    WebElement deleteConfirmationBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
