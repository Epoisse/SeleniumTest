package com.uitestpractice.pages;

import com.uitestpractice.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectPage extends CommonMethods {

    public @FindBy(id = "countriesSingle")
    WebElement countryDD;

    public @FindBy(id = "countriesMultiple")
    WebElement countryMultiDD;

    public @FindBy(id = "dropdownMenu1")
    WebElement countriesDDBtn;

    public @FindBy(xpath = "//ul[@class='dropdown-menu']//a")
    List<WebElement> countriesOptions;

    public SelectPage() {
        PageFactory.initElements(driver, this);
    }
}
