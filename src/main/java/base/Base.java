package main.java.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = loadConfig();
        String browserName = prop.getProperty("browser");

        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "/c/Cursos/JavaSelFramework/MySeleniumFramework/src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver",
                    "/c/Cursos/JavaSelFramework/MySeleniumFramework/src/main/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println(browserName + " is not a valid browser");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }

    public Properties loadConfig() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:/src/main/resources/config.properties");

        prop.load(fis);
        return prop;
    }

    public void navigateTo(String url){
        driver.get(url);
    }
}
