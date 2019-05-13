package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount extends BasePage {
    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getPageTitle() {
        return driver.findElement(By.className("page-heading")).getText();
    }

    private WebElement loggedInUser() {
        return driver.findElement(By.xpath("//a[@title='View my customer account']"));
    }

    private WebElement signOutLink() {
        return driver.findElement(By.className("logout"));
    }

    public String getUsername() {
        String userString = null;
        if (loggedInUser() != null) {
            userString = loggedInUser().getText();
        }
        return userString;
    }

    public void signOut() throws Exception {
        if (signOutLink() != null) {
            signOutLink().click();
        }
    }

    public boolean isSignedOut() throws Exception {
        boolean signedOut = false;
        if (signOutLink() == null) {
            signedOut = true;
        } else {
            System.out.println("User is logged in");
        }
        return signedOut;
    }
}
