package com.uitestpractice.pages;

import com.uitestpractice.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActionsPage extends BaseClass {

    public @FindBy(css = "button[onclick ^='myClick']")
    WebElement clickMeBtn;

    public @FindBy(css = "button[name *='dbl']")
    WebElement doublClickMeBtn;

    //drag and drop block

    public @FindBy(id = "draggable")
    WebElement draggable;

    public @FindBy(id = "droppable")
    WebElement droppable;

    public @FindBy(id = "div2")
    WebElement droppable2;

    //table of selectable numbers
    public @FindBy(xpath = "//ol[@id ='selectable']/li")
    List<WebElement> numbersTable;

    public ActionsPage() {
        PageFactory.initElements(driver, this);
    }
}
