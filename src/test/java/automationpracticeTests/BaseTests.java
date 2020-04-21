package automationpracticeTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseTests {
    private WebDriver driver;

    public String getPageTitle() {
        return driver.findElement(pageSubtitle).getText().trim();
    }

    By pageSubtitle = By.className("navigation_page");
}
