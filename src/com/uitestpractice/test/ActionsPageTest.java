package com.uitestpractice.test;

import com.uitestpractice.pages.ActionsPage;
import com.uitestpractice.pages.MainPage;
import com.uitestpractice.testbase.BaseClass;
import com.uitestpractice.utils.CommonMethods;

public class ActionsPageTest {
    public static void main(String[] args) {
        BaseClass.openWebpageWithUrl("http://www.uitestpractice.com/");
        MainPage mainPage = new MainPage();
        CommonMethods.click(mainPage.actionLink);

        ActionsPage actionsPage = new ActionsPage();
        CommonMethods.click(actionsPage.clickMeBtn);
        CommonMethods.switchToAlertAndAccept();
        CommonMethods.doubleClick(actionsPage.doublClickMeBtn);
        CommonMethods.switchToAlertAndAccept();
        CommonMethods.takingScreenshot("screenshots/Uitest/clickAndDoubleclick.png");

        CommonMethods.dragAndDrop(actionsPage.draggable, actionsPage.droppable);
        CommonMethods.dragAndDrop(actionsPage.droppable, actionsPage.droppable2);
        CommonMethods.takingScreenshot("screenshots/Uitest/dragAndDropActionsPage.png");

        CommonMethods.selectElementFromTable(actionsPage.numbersTable, "11");
        CommonMethods.takingScreenshot("screenshots/Uitest/selectedElementTable.png");

        BaseClass.tearDown();

    }
}
