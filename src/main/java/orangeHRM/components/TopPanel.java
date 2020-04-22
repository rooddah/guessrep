package orangeHRM.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopPanel {
    private WebDriver driver;

    public TopPanel(WebDriver driver) {
        this.driver = driver;
    }

    private By marketplaceBtn = By.xpath("//input[@value='Marketplace']");
    private By welcomeAdminLink = By.linkText("Welcome Admin");
    private By aboutLink = By.linkText("About");
    private By LogoutLink = By.linkText("Logout");

    public WebElement getMarketplaceBtn() {
        return driver.findElement(marketplaceBtn);
    }

    public WebElement welcomeAdmin() {
        return driver.findElement(welcomeAdminLink);
    }

    public void logout() throws Exception {
        clickOnWelcomeDropdown();
        Thread.sleep(3000);
        WebElement logout = driver.findElement(LogoutLink);
        logout.click();
    }

    public void clickOnWelcomeDropdown() {
        if (welcomeAdmin() != null) {
            welcomeAdmin().click();
        }
    }

        public void selectTab (Tabs value){
            List<WebElement> list = driver.findElements(By.xpath("//a[@class='firstLevelMenu']//b"));
            for (WebElement tab : list) {
                String tabName = tab.getText();
                if (tabName.equals(value.toString())) {
                    tab.click();
                    break;
                }
            }
        }

        public boolean isTabSelected (Tabs tab){
            boolean selected = false;
            WebElement currentTab = driver.findElement(By.xpath("//li[@class='current']//a[@class='firstLevelMenu']//b"));
            String currentTabStr = currentTab.getText();
            if (currentTabStr.equalsIgnoreCase(tab.toString())) {
                selected = true;
            }
            return selected;
        }

        public enum Tabs {
            ADMIN("Admin"),
            PIM("PIM"),
            LEAVE("Leave"),
            TIME("Time"),
            RECRUITMENT("Recruitment"),
            PERFORMANCE("Performance"),
            DASHBOARD("Dashboard"),
            DIRECTORY("Directory"),
            MAINTENANCE("Maintenance");

            private String name;

            Tabs(String s) {
                name = s;
            }

            public String toString() {
                return this.name;
            }
        }
    }
