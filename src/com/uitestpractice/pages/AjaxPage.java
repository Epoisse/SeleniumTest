package com.uitestpractice.pages;

import com.uitestpractice.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxPage extends CommonMethods {

    public @FindBy(partialLinkText = "Ajax link")
    WebElement ajaxInnerLink;

    public @FindBy(css = "div.ContactUs")
    WebElement getAjaxLinkText;

    public AjaxPage() {
        PageFactory.initElements(driver, this);
    }

}
