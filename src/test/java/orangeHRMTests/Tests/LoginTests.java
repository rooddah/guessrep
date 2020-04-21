package orangeHRMTests.Tests;
import orangeHRM.Login;
import orangeHRM.Pages.Dashboard;
import orangeHRM.components.TopPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static orangeHRM.components.TopPanel.Tabs.DASHBOARD;

public class LoginTests extends BaseTest {
    protected static WebDriver driver;

    Login loginPage;
    TopPanel topPanel;
    Dashboard dashboard;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = new FirefoxDriver();
        dashboard = new Dashboard(driver);
        loginPage = new Login(driver);
        topPanel = new TopPanel(driver);
        loadprop();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void tc01_login() throws Exception {
        loginPage.login(username, password);
        Assert.assertTrue(dashboard.topPanel().isTabSelected(DASHBOARD));
        Assert.assertTrue(dashboard.topPanel().welcomeAdmin().isDisplayed());
        dashboard.topPanel().logout();
    }
}
