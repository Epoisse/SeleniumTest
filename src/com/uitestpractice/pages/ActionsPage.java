package com.uitestpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionsPage {

    @FindBy(css = "button[onclick ^='myClick']")
    WebElement clickMeBtn;

    @FindBy(css = "button[name *='dbl']")
    WebElement doublClickMeBtn;

    //drag and drop block

    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    @FindBy(id = "div2")
    WebElement droppable2;

    //table of selectable numbers
    @FindBy(xpath = "//ol[@id ='selectable']/li")
    List <WebElement> numbersTable;

}
