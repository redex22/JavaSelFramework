package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;


public class CheckoutPage {
    @FindBy(id = "country")
    private WebElement locationBox;

    @FindBy(linkText = "United States of America")
    private WebElement usaCountry;

    @FindBy(css = "label[for='checkbox2']")
    private WebElement conditionsCheckBox;

    @FindBy(css = "input[value='Purchase']")
    private WebElement purchase;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement finalAlert;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLocationBox() {
        return locationBox;
    }

    public WebElement getUsaCountry() {
        return usaCountry;
    }

    public WebElement getConditionsCheckBox() {
        return conditionsCheckBox;
    }

    public WebElement getPurchase() {
        return purchase;
    }

    public WebElement getFinalAlert() {
        return finalAlert;
    }
}
