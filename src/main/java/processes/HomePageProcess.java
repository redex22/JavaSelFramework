package processes;

import actions.Action;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageProcess extends Action {

    WebDriver driver;
    private HomePage homePage;

    public HomePageProcess(WebDriver driver){
        super(driver);
        homePage = new HomePage(driver);
    }

    public void sendNameKeys(String name){
        this.sendData(homePage.getInputName(), name);
    }

    public void sendEmailKeys(String email){
        this.sendData(homePage.getInputEmail(), email);
    }
    public void sendPassKeys(String passw){
        this.sendData(homePage.getInputPassword(), passw);
    }

    public void clickIceCreamBox(){
        this.doClick(homePage.getIceCreamCB());
    }

    public void selectInGenderBox(String selection){
        this.selectInABox(homePage.getGenderBox(), selection);
    }

    public void clickEmployedButton(){
        this.doClick(homePage.getEmployedButton());
    }

    public void clickOnSubmit(){
        this.doClick(homePage.getSubmitButton());
    }

    public String getAlertAfterSubmission(){
        return this.getText(homePage.getHomeAlert());
    }

    public void goToShopPage(){
        this.doClick(homePage.getShopPageButton());
    }
}
