package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class Action {

    private WebDriver driver;

    public Action(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void doClick(WebElement element){
        element.click();
    }

    public void sendData(WebElement element, String value){
        element.sendKeys(value);
    }

    public void selectInABox(WebElement element, String selection){
        Select box = new Select(element);
        box.selectByVisibleText(selection);
    }

    public String getText(WebElement element){
        return element.getText();
    }
}
