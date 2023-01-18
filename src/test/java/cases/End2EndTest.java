package cases;

import com.codoid.products.exception.FilloException;
import base.Base;
import org.testng.annotations.*;
import pages.HomePage;
import processes.CheckoutPageProcess;
import processes.HomePageProcess;
import processes.ShopPageProcess;
import utilities.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;

public class End2EndTest extends Base {

    public static WebDriver driver;

    private Logger log = LogManager.getLogger(HomePage.class.getName());
    private HashMap<String, String> data;


    @BeforeMethod
    public void initialize() throws IOException, FilloException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        data = new Utils().getExcelData("formData", "testDataPath","TCID", "TC03");
        log.info("TC03 data is loaded");
    }

    @Test
    public void endToEnd() throws FilloException, IOException {
        HomePageProcess homePage = new HomePageProcess(driver);
        ShopPageProcess shopPage = new ShopPageProcess(driver);
        CheckoutPageProcess checkoutPage = new CheckoutPageProcess(driver);

        log.info("TC03: End to end of the e-commerce.");

        this.navigateTo(prop.getProperty("urlHome"));

        log.info("Step 1: Write the name, email and password data in the respective boxes");
        homePage.sendNameKeys(data.get("Name"));
        homePage.sendEmailKeys(data.get("Email"));
        homePage.sendPassKeys(data.get("Password"));
        log.info("Step 2: Select the Ice Cream, Gender and Employed options");
        homePage.clickIceCreamBox();
        homePage.selectInGenderBox(data.get("Gender"));
        homePage.clickEmployedButton();
        log.debug("Employed button clicked");
        log.info("Step 3: Submit the form");
        homePage.clickOnSubmit();
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Success!"));
        log.info("Successfully submission");

        log.info("Step 4: Navigating to Shop Page");
        homePage.goToShopPage();
        log.info("Step 5: Buy a Nokia Edge smartphone");
        shopPage.buyAProduct(data.get("ProductName"));
        shopPage.clickOnBuyButton();
        log.info("Step 6: Go to Checkout Page");
        shopPage.clickOnCheckoutButton();

        log.info("Step 7: Select a country as location for delivery");
        checkoutPage.sendLocationKeys(data.get("SearchCountry"));
        checkoutPage.clickOnCountry(data.get("Country"));
        log.info("Step 8: Accept the conditions and terms. And buy the item.");
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
