package net.syntaxtechs.hrm.test;

import net.syntaxtechs.hrm.pages.LoginPage;
import net.syntaxtechs.hrm.testbase.BaseClass;
import net.syntaxtechs.hrm.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageEmptyUsername {
    public static void main(String[] args) {
        BaseClass.openChromeBrowser("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage();
        loginPage.loginBtn.click();
        WebElement msg = BaseClass.driver.findElement(By.xpath("//input[@id='btnLogin']/following-sibling::span"));
        if (msg.getText().equals("Username cannot be empty")) {
            System.out.println("the error message has verified");
        } else System.out.println("the error message has not been verified");

        CommonMethods.highlighting(msg);
        CommonMethods.takingScreenShots("screenshots/HRM/errormsgEmptyUsername.png");
    }
}