package cases;

import com.codoid.products.exception.FilloException;
import base.Base;
import org.testng.annotations.*;
import pages.HomePage;
import processes.HomePageProcess;
import utilities.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;

public class HomePageTest extends Base {

    public WebDriver driver;
    private Logger log = LogManager.getLogger(HomePage.class.getName());
    private HashMap<String, String> data;
    private HashMap<String, String> dataTC2;

    @BeforeMethod
    public void initialize() throws IOException, FilloException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        data = new Utils().getTestData("TC01");
        dataTC2 = new Utils().getTestData("TC02");
        log.info("TCs data is loaded");
    }

    @Test
    public void fillSendForm() {
        HomePageProcess homePage = new HomePageProcess(driver);
        this.navigateTo(prop.getProperty("urlHome"));

        log.info("Step 1: Write the name, email and password data in the respective boxes");
        homePage.sendNameKeys(data.get("Name"));
        log.debug("Name sent");
        homePage.sendEmailKeys(data.get("Email"));
        log.debug("Email sent");
        homePage.sendPassKeys(data.get("Password"));
        log.debug("Password sent");
        log.info("Step 2: Select the Ice Cream, Gender and Employed options");
        homePage.clickIceCreamBox();
        log.debug("Ice Cream box checked");
        homePage.selectInGenderBox(data.get("Gender"));
        log.debug("Gender selected");
        homePage.clickEmployedButton();
        log.debug("Employed button clicked");
        log.info("Step 3: Submit the form");
        homePage.clickOnSubmit();
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Success!"));
        log.info("Successfully submission");
    }

    @Test
    public void fillSendFormWithoutPassword() {
        HomePageProcess homePage = new HomePageProcess(driver);
        this.navigateTo(prop.getProperty("urlHome"));

        log.info("Step 1: Write the name and email data in the respective boxes");
        homePage.sendNameKeys(dataTC2.get("Name"));
        log.debug("Name sent");
        homePage.sendEmailKeys(dataTC2.get("Email"));
        log.debug("Email sent");
        log.info("Step 2: Select the Ice Cream, Gender and Employed options");
        homePage.clickIceCreamBox();
        log.debug("Ice Cream box checked");
        homePage.selectInGenderBox(dataTC2.get("Gender"));
        log.debug("Gender selected");
        homePage.clickEmployedButton();
        log.debug("Employed button clicked");
        log.info("Step 3: Submit the form");
        homePage.clickOnSubmit();
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Success!"));
        log.info("Successfully submission");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        log.info("Driver is closed");
    }
}
