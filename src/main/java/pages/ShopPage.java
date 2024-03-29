package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.rahulshettyacademy.com/angularpractice/shop

public class ShopPage {

    private WebDriver driver;

    // phone card boxes
    @FindBy(xpath = "//div[@class='card h-100']")
    private List<WebElement> cardBoxes;
    //private By cardBoxes = new By.ByXPath("//div[@class='card h-100']");

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    private WebElement buyButton;

    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    private WebElement checkOutButton;


    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCardBoxes() {
        return cardBoxes;
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getCheckOutButton() {
        return checkOutButton;
    }
}
