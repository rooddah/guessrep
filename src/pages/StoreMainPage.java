package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreMainPage {

    private WebDriver driver;

    By pageTitle = By.linkText("My Store");
    By signInLink = By.partialLinkText("Sign in");
    By contactUsLink = By.linkText("Contact Us");
    By searchInput = By.xpath("//input[@id='search_query_top']");

    public StoreMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getpageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void clickSignIn(){
        driver.findElement(signInLink).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }


}
