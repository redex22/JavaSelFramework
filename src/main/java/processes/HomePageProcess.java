package processes;

import actions.Action;
import com.codoid.products.exception.FilloException;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePageProcess extends Action {

    private WebDriver driver;
    private HomePage homePage;

    public HomePageProcess(WebDriver driver) throws FilloException, IOException {
        super(driver);
        homePage = new HomePage(driver);
    }

    public void sendNameKeys(String name) throws FilloException, IOException {
        this.sendData(homePage.getInputName(), name);
    }

    public void sendEmailKeys(String email) throws FilloException, IOException {
        this.sendData(homePage.getInputEmail(), email);
    }
    public void sendPassKeys(String passw) throws FilloException, IOException {
        this.sendData(homePage.getInputPassword(), passw);
    }

    public void clickIceCreamBox() throws FilloException, IOException {
        this.doClick(homePage.getIceCreamCB());
    }

    public void selectInGenderBox(String selection) throws FilloException, IOException {
        this.selectInABox(homePage.getGenderBox(), selection);
    }

    public void clickEmployedButton() throws FilloException, IOException {
        this.doClick(homePage.getEmployedButton());
    }

    public void clickOnSubmit() throws FilloException, IOException {
        this.doClick(homePage.getSubmitButton());
    }

    public String getAlertAfterSubmission() throws FilloException, IOException {
        return this.getText(homePage.getHomeAlert());
    }

    public void goToShopPage() throws FilloException, IOException {
        this.doClick(homePage.getShopPageButton());
    }
}
