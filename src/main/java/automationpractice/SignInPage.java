package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver ) {
        super(driver);
    }
    
    By pageTitle = By.xpath("//h1[@class='page-heading']");

    // 'Create an Account' section for new user
    private WebElement emailNewInput() {
        return driver.findElement(By.xpath("//input[@id='email_create']"));
    }

    private WebElement buttonCreateAccount() {
        return driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
    }

    //'Already Registered?' section for existing user
    private WebElement emailExistingInput() {
        return driver.findElement(By.xpath("//input[@id='email']"));
    }

    private WebElement passwordInput() {
        return driver.findElement(By.xpath("//input[@id='passwd']"));
    }

    private WebElement forgotPassLink() {
        return driver.findElement(By.linkText("Forgot your password?"));
    }

    private WebElement signInButton() {
        return driver.findElement(By.xpath("//button[@name='SubmitLogin']"));
    }

    private WebElement error() {
        return driver.findElement(By.id("create_account_error"));
    }

    public void clickCreate() {
        buttonCreateAccount().click();
    }

    public String errorMessageContent() {
        String contentString = "";
        if (error() != null) {
            contentString = error().getText();
        }
        return contentString;
    }

    /**
     * method set email text in the email input for new users
     * @param pEmailAddress
     */
    public void setEmail(String pEmailAddress) {
        emailNewInput().sendKeys(pEmailAddress);
    }

    /**
     * method set email text in the input and click on Create button
     * @param pEmailAddress
     */
    public void setEmailAndCreate(String pEmailAddress) {
        setEmail(pEmailAddress);
        clickCreate();
    }

    public void clearEmailNew() {
        emailNewInput().clear();
    }

    /**
     * method set email text in the email input for existing users
     * @param pEmail
     */
    public void setEmailExisting(String pEmail) throws Exception {
        emailExistingInput().sendKeys(pEmail);
    }

    public void setPassword(String pPass) throws Exception {
        passwordInput().sendKeys(pPass);
    }

    public void clickSignIn() {
        signInButton().click();
    }

    public void logIn(String pEmail, String pPass) throws Exception {
        setEmailExisting(pEmail);
        setPassword(pPass);
        clickSignIn();
    }
}
