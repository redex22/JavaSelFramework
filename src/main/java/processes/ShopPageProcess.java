package processes;

import actions.Action;
import pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopPageProcess extends Action {

    private WebDriver driver;
    private ShopPage shopPage;

    public ShopPageProcess(WebDriver driver){
        super(driver);
        shopPage = new ShopPage(driver);
    }

    public void buyAProduct(String productName){
        for(WebElement product : shopPage.getCardBoxes()){
            String title = this.getText(product.findElement(By.xpath("div/h4/a")));
            if(title.equals(productName)){
                this.doClick(product.findElement(By.tagName("button")));
                break;
            }
        }
    }

    public void clickOnBuyButton(){
        this.doClick(shopPage.getBuyButton());
    }

    public void clickOnCheckoutButton(){
        this.doClick(shopPage.getCheckOutButton());
    }
}
