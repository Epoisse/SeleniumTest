package net.syntaxtechs.hrm.pages;

import net.syntaxtechs.hrm.testbase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseClass {
    public WebElement pimLnk = driver.findElement(By.id("menu_pim_viewPimModule"));
}
