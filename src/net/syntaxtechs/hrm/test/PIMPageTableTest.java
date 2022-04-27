package net.syntaxtechs.hrm.test;

import net.syntaxtechs.hrm.pages.LoginPage;
import net.syntaxtechs.hrm.pages.MainPage;
import net.syntaxtechs.hrm.pages.PIM;
import net.syntaxtechs.hrm.testbase.BaseClass;
import net.syntaxtechs.hrm.utils.CommonMethods;
import org.openqa.selenium.WebElement;

public class PIMPageTableTest {
    public static void main(String[] args) {
        BaseClass.openChromeBrowser("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage();
        CommonMethods.sendText(loginPage.username, "Admin");
        CommonMethods.sendText(loginPage.password, "Hum@nhrm123");
        loginPage.loginBtn.click();
        MainPage mainPage = new MainPage();
        mainPage.pimLnk.click();
        PIM pim = new PIM();


        System.out.println(pim.tableColumns.size());
        System.out.println(pim.tableRows.size());

        for (WebElement tableColumn : pim.tableColumns) {
            String text = tableColumn.getText();
            System.out.println(text);
        }
    }
}
