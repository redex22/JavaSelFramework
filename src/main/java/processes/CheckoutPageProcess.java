package processes;

import actions.Action;
import pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class CheckoutPageProcess extends Action {

    WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutPageProcess(WebDriver driver){
        checkoutPage = new CheckoutPage(driver);
    }

    public void sendLocationKeys(String location){
        this.sendData(checkoutPage.getLocationBox(), location);
    }

    public void clickOnUsaCountry(String country){
        this.verifyByLinkText(country);
        this.doClick(checkoutPage.getUsaCountry());
    }

    public void clickOnConditionsCB(){
        this.doClick(checkoutPage.getConditionsCheckBox());
    }

    public void clickOnPurchase(){
        this.doClick(checkoutPage.getPurchase());
    }

    public String getFinalAlert(){
        return this.getText(checkoutPage.getFinalAlert());
    }
}
