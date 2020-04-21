package orangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.cssSelector("#txtUsername");
    private By password = By.cssSelector("#txtPassword");
    private By login = By.cssSelector("#btnLogin");
    private By forgotPassword = By.linkText("Forgot your password?");

    public WebElement getUsernameInput() {
        return driver.findElement(username);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(password);
    }

    public WebElement getLoginButton() {
        return driver.findElement(login);
    }

    public WebElement getForgotYourPassLink() {
        return driver.findElement(forgotPassword);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    public void login(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        clickLogin();
    }
}
