import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*
ВАЖНО!
Данный класс не рабочий, в нем исключительно демонстрация варианта подставновки переменной в селектор.

 */

public class ScooterPage {

    WebDriver driver;



    public void clickOnMetroStation(String stationName) {
        driver.findElement(By.xpath(".//*[text()='" + stationName + "']"));
    }

}
