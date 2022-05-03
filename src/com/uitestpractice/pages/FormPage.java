package com.uitestpractice.pages;

import com.uitestpractice.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPage extends CommonMethods {

    public @FindBy(id = "firstname")
    WebElement firstName;

    public @FindBy(id = "lastname")
    WebElement lastName;

    public @FindBy(xpath = "//label[@class='radio-inline']")
    List<WebElement> martialStatus;

    public @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> hobby;

    public @FindBy(id = "sel1")
    WebElement countryDD;

    public @FindBy(id = "datepicker")
    WebElement datepicker;

    public @FindBy(xpath = "//select[@data-handler='selectMonth']")
    WebElement dobMonth;

    public @FindBy(xpath = "//select[@data-handler='selectYear']")
    WebElement dobYear;

    public @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
    List<WebElement> dobDates;

    public @FindBy(id = "phonenumber")
    WebElement phoneNumber;

    public @FindBy(id = "username")
    WebElement userName;

    public @FindBy(id = "email")
    WebElement email;

    public @FindBy(id = "comment")
    WebElement aboutYourself;

    public @FindBy(id = "pwd")
    WebElement password;

    public @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    public FormPage() {
        PageFactory.initElements(driver, this);
    }

}
