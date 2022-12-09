package main.java.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Action {

    WebDriver driver;

    public void doClick(WebElement element){
        element.click();
    }

    public void sendData(WebElement element, String value){
        element.sendKeys(value);
    }

    public void verifyByLinkText(String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
    }

    public void selectInABox(WebElement element, String selection){
        Select box = new Select(element);
        box.selectByVisibleText(selection);
    }

    public String getText(WebElement element){
        return element.getText();
    }
}
