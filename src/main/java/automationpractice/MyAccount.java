package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount extends BasePage {

    public MyAccount (WebDriver driver) {
        super(driver);
    }

    By loggedInUser = By.cssSelector(".account");
    By signOutLinkBy = By.cssSelector(".logout");
    By signInLinkBy = By.cssSelector(".login");

    private WebElement loggedInUser() {
        return driver.findElement(loggedInUser);
    }

    private WebElement signOutLink() {
        return driver.findElement(signOutLinkBy);
    }

    private WebElement signInLink() {
        return driver.findElement(signInLinkBy);
    }

    public String getUsername() {
        String userString = null;
        if (loggedInUser != null) {
            userString = loggedInUser().getText();
        }
        return userString;
    }

    public void signOut() throws Exception {
        if (signOutLinkBy != null) {
        	driver.findElement(signOutLinkBy).click();
        }
    }

    public boolean isSignedIn() throws Exception {
        boolean signedIn = false;
        if (driver.findElements(signOutLinkBy).size()!= 0) {
            System.out.println("User is signed in");
            signedIn = true;
        } else {
            System.out.println("User is not signed in");
        }
        return signedIn;
    }
}
