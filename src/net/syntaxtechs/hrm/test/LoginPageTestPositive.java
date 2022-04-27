package net.syntaxtechs.hrm.test;

import net.syntaxtechs.hrm.pages.LoginPage;
import net.syntaxtechs.hrm.testbase.BaseClass;
import net.syntaxtechs.hrm.utils.CommonMethods;

public class LoginPageTestPositive {
    public static void main(String[] args) {
        BaseClass.openChromeBrowser("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginPage loginPage=new LoginPage();
        CommonMethods.sendText(loginPage.username, "Admin");
        CommonMethods.sendText(loginPage.password, "Hum@nhrm123");
        loginPage.loginBtn.click();
    }
}
