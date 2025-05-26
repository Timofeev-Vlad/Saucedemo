package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private static final By REMOVEGOODBTN = By.xpath("//*[text()='Remove']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductNames) {
            names.add(product.getText());
        }
        return names;
    }

    public void remove() {
        driver.findElement(REMOVEGOODBTN).click();
    }
}
