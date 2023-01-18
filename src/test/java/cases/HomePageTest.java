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
    private String sheetName = "formData";
    private String dataPath = "testDataPath";
    private String idColumn = "TCID";
    private String id_1 = "TC01";
    private String id_2 = "TC02";

    @BeforeMethod
    public void initialize() throws IOException, FilloException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        data = new Utils().getExcelData(sheetName, dataPath,idColumn, id_1);
        dataTC2 = new Utils().getExcelData(sheetName, dataPath,idColumn, id_2);
        log.info("TCs data is loaded");
    }

    @Test
    public void fillSendForm() throws FilloException, IOException {
        HomePageProcess homePage = new HomePageProcess(driver);

        log.info("TC01: Filling all the form and send it.");

        this.navigateTo(prop.getProperty("urlHome"));

        log.info("Step 1: Write the name, email and password data in the respective boxes");
        homePage.sendNameKeys(data.get("Name"));
        homePage.sendEmailKeys(data.get("Email"));
        homePage.sendPassKeys(data.get("Password"));
        log.info("Step 2: Select the Ice Cream, Gender and Employed options");
        homePage.clickIceCreamBox();
        homePage.selectInGenderBox(data.get("Gender"));
        homePage.clickEmployedButton();
        log.info("Step 3: Submit the form");
        homePage.clickOnSubmit();
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Success!"));
        log.info("Successfully submission");
    }

    @Test
    public void fillSendFormWithoutPassword() throws FilloException, IOException {
        HomePageProcess homePage = new HomePageProcess(driver);

        log.info("TC02: Filling the form without the password and send it.");

        this.navigateTo(prop.getProperty("urlHome"));

        log.info("Step 1: Write the name and email data in the respective boxes");
        homePage.sendNameKeys(dataTC2.get("Name"));
        homePage.sendEmailKeys(dataTC2.get("Email"));
        log.info("Step 2: Select the Ice Cream, Gender and Employed options");
        homePage.clickIceCreamBox();
        homePage.selectInGenderBox(dataTC2.get("Gender"));
        homePage.clickEmployedButton();
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
