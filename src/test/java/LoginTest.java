import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class LoginTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //Используем менеджер для простой и удобной подготовки драйверов
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // С помощью менеджера смена драйвера занимает 2 строчки.
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        WebDriverManager.chromiumdriver().setup();
//        driver = new ChromiumDriver();
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

    }

    @Test
    public void loginTest() {
        // Если испльзуем паттерн chain of responsibility то код можно сократить до 1-2 строчек
//        driver.get("https://www.saucedemo.com");
//        assertTrue(new LoginPage(driver).login("standard_user", "secret_sauce").checkCardsDisplayed());
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        MainPage mainPage = new MainPage(driver);
        assertFalse(mainPage.checkCardsDisplayed());
    }

    @Test
    public void testDropdown() {
//        ScooterPage scooterPage = new ScooterPage();
//        scooterPage.clickOnMetroStation("Бahsjkbgasjkdhasjkdhaskldhck");
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.findElement(By.className("select-search")).click();
        WebElement station = driver.findElement(By.xpath(".//*[text()='Бульвар Рокоссовского']"));
        station.getText();
    }
}
