package pages;

import org.openqa.selenium.By;
import utilities.Utils;

import java.util.HashMap;

public abstract class AbstractLocatorPage extends Utils {

    public By findLocator(HashMap<String, String> locatorsPath){
        String locator = locatorsPath.get("locator");
        String path = locatorsPath.get("path");
        switch(locator){
            case "name":
                return By.name(path);
            case "xpath":
                return By.xpath(path);
            case "cssSelector":
                return By.cssSelector(path);
            case "id":
                return By.id(path);
            default:
                break;
        }
        return null;
    }
}
