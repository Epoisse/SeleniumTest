package net.syntaxtechs.hrm.test;

import net.syntaxtechs.hrm.pages.LoginPage;
import net.syntaxtechs.hrm.testbase.BaseClass;
import net.syntaxtechs.hrm.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageInvalidCredentials {
    public static void main(String[] args) {

        BaseClass.openChromeBrowser("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("Admin");
        loginPage.password.sendKeys("wrongPassword");
        loginPage.loginBtn.click();

        WebElement msg = BaseClass.driver.findElement(By.xpath("//span[@id='spanMessage']"));

        if (msg.getText().equals("Invalid credentials")) {
            System.out.println("The message has confirmed");
        } else {
            System.out.println("The message is not correct");
        }

        CommonMethods.highlighting(msg);
        CommonMethods.takingScreenShots("screenshots/HRM/invalidCredentials.png");

        BaseClass.driver.quit();

    }
}
