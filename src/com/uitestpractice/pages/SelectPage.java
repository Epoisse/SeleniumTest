package com.uitestpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectPage {

    @FindBy(id = "countriesSingle")
    WebElement countryDD;

    @FindBy(id = "countriesMultiple")
    WebElement countryMultiDD;

    @FindBy(id = "dropdownMenu1")
    WebElement countriesDD;
}
