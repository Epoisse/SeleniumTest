package net.syntaxtechs.hrm.pages;

import net.syntaxtechs.hrm.testbase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PIM extends BaseClass {


    public List<WebElement> tableRows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
    public List <WebElement> tableColumns= driver.findElements(By.xpath("//table[@id='resultTable']//th"));
}
