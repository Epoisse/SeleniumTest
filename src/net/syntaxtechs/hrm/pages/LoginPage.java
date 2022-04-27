package net.syntaxtechs.hrm.pages;

import javafx.css.CssMetaData;
import net.syntaxtechs.hrm.testbase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    //public WebElement username = driver.findElement(By.id("txtUsername"));
    //public WebElement password = driver.findElement(By.id("txtPassword"));
    //public WebElement loginBtn = driver.findElement(By.cssSelector("input[value *='LOG']"));

    @FindBy (id ="txtUsername")
    public WebElement username;

    @FindBy (id = "txtPassword")
    public WebElement password;

    @FindBy (css = "input[value *='LOG']")
    public WebElement loginBtn;

    public LoginPage (){
        PageFactory.initElements(BaseClass.driver, this);
    }
}
