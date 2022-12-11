package cases;

import com.codoid.products.exception.FilloException;
import base.Base;
import pages.HomePage;
import processes.HomePageProcess;
import utilities.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;

public class HomePageTest extends Base {

    public WebDriver driver;
    private Logger log = LogManager.getLogger(HomePage.class.getName());
    private HashMap<String, String> data;

    @BeforeMethod
    public void initialize() throws IOException, FilloException {
        driver = initializeDriver();
        log.debug("Driver is initialized.");
        data = new Utils().getTestData("TC01");
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
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Succes!"));
        log.info("Successfully submission");

    }
    @Test
    public void fillSendForm2() {
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

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("Driver is closed");
    }
}
