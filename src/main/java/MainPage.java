import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inventoryItemCard = By.className("inventory_item");

    public boolean checkCardsDisplayed() {
        return driver.findElements(inventoryItemCard).size() > 0;
    }
}
