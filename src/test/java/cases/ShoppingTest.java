package cases;

import base.Base;
import com.codoid.products.exception.FilloException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import processes.CheckoutPageProcess;
import processes.ShopPageProcess;
import utilities.Utils;

import java.io.IOException;
import java.util.HashMap;

public class ShoppingTest extends Base {

    public WebDriver driver;
    private Logger log = LogManager.getLogger(HomePage.class.getName());
    private HashMap<String, String> data;

    @BeforeMethod
    public void initialize() throws IOException, FilloException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        data = new Utils().getExcelData("formData", "testDataPath","TCID", "TC04");
        log.info("TC data is loaded");
    }

    @Test
    public void buyingASmartphoneAndDeliverToIndia() {
        ShopPageProcess shopPage = new ShopPageProcess(driver);
        CheckoutPageProcess checkoutPage = new CheckoutPageProcess(driver);

        log.info("TC04: Buying a Blackberry smartphone and send it to India.");

        this.navigateTo(prop.getProperty("urlShop"));

        log.info("Step 1: Buy a Blackberry smartphone");
        shopPage.buyAProduct(data.get("ProductName"));
        shopPage.clickOnBuyButton();
        log.info("Step 2: Go to Checkout Page");
        shopPage.clickOnCheckoutButton();

        log.info("Step 3: Select a country as the location for delivery");
        checkoutPage.sendLocationKeys(data.get("SearchCountry"));
        checkoutPage.clickOnCountry(data.get("Country"));
        log.info("Step 4: Accept the conditions and terms. And buy the item.");
        checkoutPage.clickOnConditionsCB();
        checkoutPage.clickOnPurchase();
        String finalAlert = checkoutPage.getFinalAlert();
        Assert.assertTrue(finalAlert.contains("Success!"));
        log.info("Successfully purchase");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        log.info("Driver is closed");
    }
}
