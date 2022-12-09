package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.rahulshettyacademy.com/angularpractice/

public class HomePage{

    /*
     * Page Object encapsulates the pages.HomePage page.
     */

    protected WebDriver driver;

    @FindBy(name = "name")
    private WebElement inputName;

    @FindBy(id = "exampleInputPassword1")
    private WebElement inputPassword;

    @FindBy(xpath = "//label[normalize-space()='Check me out if you Love IceCreams!']")
    private WebElement iceCreamCB;

    @FindBy(css = "#exampleFormControlSelect1")
    private WebElement genderBox;

    @FindBy(css = "#inlineRadio2")
    private WebElement employedButton;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement homeAlert;

    @FindBy(xpath = "//a[normalize-space()='Shop']")
    private WebElement shopPageButton;

    @FindBy(name = "email")
    private WebElement inputEmail;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        if (!driver.getTitle().equals("ProtoCommerce")) {
            throw new IllegalStateException("This is not the Home Page\n" +
                    "Current page is: " + driver.getCurrentUrl());
        }
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getIceCreamCB() {
        return iceCreamCB;
    }

    public WebElement getGenderBox() {
        return genderBox;
    }

    public WebElement getEmployedButton() {
        return employedButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getHomeAlert() {
        return homeAlert;
    }

    public WebElement getShopPageButton() {
        return shopPageButton;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }
}
