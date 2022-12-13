package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {

    private WebDriver driver;


    @FindBy(id = "country")
    private WebElement locationBox;


    @FindBy(css = "label[for='checkbox2']")
    private WebElement conditionsCheckBox;

    @FindBy(css = "input[value='Purchase']")
    private WebElement purchase;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement finalAlert;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLocationBox() {
        return locationBox;
    }

    public WebElement getCountry(String country) {
        By countryElement = new By.ByLinkText(country);
        return driver.findElement(countryElement);
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

    public WebDriver getDriver() {
        return this.driver;
    }
}
