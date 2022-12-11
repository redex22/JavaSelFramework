package cases;

import main.java.base.Base;
import main.java.pages.HomePage;
import main.java.processes.HomePageProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;

public class HomePageTest extends Base {

    public WebDriver driver;
    private Logger log = LogManager.getLogger(HomePage.class.getName());

    @BeforeMethod
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.debug("Driver is initialized.");
    }

    @Test
    public void fillSendForm() {
        HomePageProcess homePage = new HomePageProcess(driver);
        this.navigateTo(prop.getProperty("url"));

        homePage.sendNameKeys("Gonza");
        log.debug("Name sent");
        homePage.sendEmailKeys("gon@gmail.com");
        log.debug("Email sent");
        homePage.sendPassKeys("1234");
        log.debug("Password sent");
        homePage.clickIceCreamBox();
        log.debug("Ice Cream box checked");
        homePage.selectInGenderBox("Male");
        log.debug("Gender selected");
        homePage.clickEmployedButton();
        log.debug("Employed button clicked");
        homePage.clickOnSubmit();
        Assert.assertTrue(homePage.getAlertAfterSubmission().contains("Success!"));
        log.info("Successfully submission");

    }

    @DataProvider
    public Object[][] getData() {
        // Each row is set of test data for a test case
        // Each column is a value in a set of test data
        Object[][] data = new Object[2][2];

        // First set of test data
        data[0][0] = "John Doe";
        data[0][1] = "ThisIsNotAPassword";

        // Second set of test data
        data[1][0] = "testuser2";
        data[1][1] = "testpwd2";

        return data;
    }

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("Driver is closed");
    }
}
