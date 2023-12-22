import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //Если мы используем способ поиска элементов с помощью аннотацией нам нужно добавить данный вызов,
        // чтобы селениум нашел нам наши элементы, иначе в переменных с аннотацией будет null.
//        PageFactory.initElements(driver, this);
    }
    /*
    Selenium предоставляет нам возможность передачи ему поиска элементов.
    Для этого нужна переменная с типом WebElement и аннотация с селектором по которому можно найти этот элемент.
    Если элемент найден - переменная будет заполнена экземпляром класс WebElement, который будет проекцией нашего элемента на странице.
     */
//    @FindBy(xpath = ".//input[@data-test='username']")
//    private WebElement usernameInput;
//
//    @FindBy(xpath = ".//input[@data-test='password']")
//    private WebElement passwordInput;
//
//    @FindBy(xpath = ".//input[@data-test='login-button']")
//    private WebElement loginButton;


    private final By usernameInput = By.xpath(".//input[@data-test='username']");

    private final By passwordInput = By.xpath(".//input[@data-test='password']");

    private final By loginButton = By.xpath(".//input[@data-test='login-button']");


    //Мы можем компоновать действия в рамках одного процесса, например логина
    //Чтобы не делать 3 отдельных вызова в тесте, мы оборачиваем эти вызовы в метод который сделает нам логин.
    public void login(String username, String password) {
        /*
        Если мы используем вариант поиска элементов с помощью аннотаций то нам больше не нужно каждый раз искать отдельно элемент,
        он уже найден и мы может сразу выполнять действия с этим элементом.
         */
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//        return new MainPage(driver);
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
