package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public abstract class BasePage {
    WebDriver driver;
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
