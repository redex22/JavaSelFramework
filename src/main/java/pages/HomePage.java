package pages;

import com.codoid.products.exception.FilloException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

// page_url = https://www.rahulshettyacademy.com/angularpractice/

public class HomePage extends AbstractLocatorPage{

    /*
     * Page Object encapsulates the pages.HomePage page.
     */
    private WebDriver driver;

    private final String sheetName = "homeLocators";
    private final String dataPath = "locatorsPath";
    private final String idColumn = "id";
    private final String inputName = "inputName";
    private final String inputPassword = "inputPassword";
    private final String iceCreamCB = "iceCreamCB";
    private final String genderBox = "genderBox";
    private final String employedButton = "employedButton";
    private final String submitButton = "submitButton";
    private final String homeAlert = "homeAlert";
    private final String shopPageButton = "shopPageButton";
    private final String inputEmail = "inputEmail";

    public HomePage(WebDriver driver) throws FilloException, IOException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getInputName() throws FilloException, IOException {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, inputName)));
    }

    public WebElement getInputPassword() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, inputPassword)));
    }

    public WebElement getIceCreamCB() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, iceCreamCB)));
    }

    public WebElement getGenderBox() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, genderBox)));
    }

    public WebElement getEmployedButton() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, employedButton)));
    }

    public WebElement getSubmitButton() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, submitButton)));
    }

    public WebElement getHomeAlert() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, homeAlert)));
    }

    public WebElement getShopPageButton() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, shopPageButton)));
    }

    public WebElement getInputEmail() throws FilloException, IOException  {
        return driver.findElement(findLocator(getExcelData(sheetName,
                dataPath, idColumn, inputEmail)));
    }
}
