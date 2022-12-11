package processes;

import actions.Action;
import pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPageProcess extends Action {

    WebDriver driver;
    private ShopPage shopPage;

    public ShopPageProcess(WebDriver driver){
        shopPage = new ShopPage(driver);
    }

    public void buyAProduct(String productName){
        for(WebElement product : shopPage.getCardBoxes()){
            String title = this.getText(product.findElement(By.xpath("div/h4/a")));
            if(title.contains(productName)){
                this.doClick(product.findElement(By.tagName("button")));
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
