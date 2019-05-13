package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage.Countries;
import pages.BasePage.Months;
import pages.BasePage.States;
import pages.BasePage.Titles;
import pages.CreateAccountPage;
import pages.MyAccount;
import pages.SignInPage;
import pages.StoreMainPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RegistrationTests {

    protected static WebDriver driver;
    private String URL = "http://automationpractice.com";
    private String email = "john.smith@domain.comas";
    private String email2 = "jane.doe@webpage.com";
    private String password = "pass123";
    private String firstname = "John";
    private String lastname = "Smith";
    private String username = firstname + " " + lastname;
    private String address = "Nice Street 1";
    private String city = "Wonderville";
    private String zip = "54321";
    private String mobile = "1928-3746-55";
    private String createAccountPageTitle = "Authentication";
    private String myAccountTitle = "My Account";
    private String errEmailExists = "has already been registered";
    private String errEmailInvalidString = "Invalid email address";
    private String justAString = "helloDarknessMyOldFriend";

    private int dayOfBirth = 1;
    private int yearOfBirth = 1985;

    StoreMainPage mainPage;
    SignInPage signPage;
    MyAccount myAccount;

    @BeforeMethod()
    public void beforeTest() {
        driver = new FirefoxDriver();
        mainPage = new StoreMainPage(driver);
        signPage = new SignInPage(driver);
        myAccount = new MyAccount(driver);
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Clicking 'Sign In' button...");
        mainPage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(signPage.getpageTitle().equalsIgnoreCase("Authentication"));
    }

    @AfterMethod()
    public void afterTest() throws Exception {
        if (!myAccount.isSignedOut()) {
            myAccount.signOut();
        }
        driver.quit();
    }

    @Test(priority = 1)
    public  void registerUser() throws Exception {

        System.out.println("Entering email and clicking 'Create' button");
        signPage.setEmail(email);
        signPage.clickCreate();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        Assert.assertTrue(createAccount.getPageTitle().equalsIgnoreCase(createAccountPageTitle));
        Assert.assertTrue(createAccount.isEmailPopulated());
        createAccount.selectRadioTitle(Titles.MR);
        createAccount.setFirstName(firstname);
        createAccount.setLastName(lastname);
        createAccount.setPassword(password);
        createAccount.selectDayOfBirth(dayOfBirth);
        createAccount.selectMonthOfBirth(Months.DECEMBER);
        createAccount.selectYearOfBirth(yearOfBirth);
        createAccount.setFirstNameAddr(firstname);
        createAccount.setLastnameAddr(lastname);
        createAccount.setAddress1(address);
        createAccount.setCity(city);
        createAccount.selectCountry(Countries.UNITED_STATES);
        createAccount.selectState(States.CALIFORNIA);
        createAccount.setZipCode(zip);
        createAccount.setMobilePhone(mobile);
        createAccount.register();
        Assert.assertTrue(myAccount.getPageTitle().equalsIgnoreCase(myAccountTitle));
    }

    @Test(priority = 2)
    public void logIn() throws Exception {
        System.out.println("Entering email and password and clicking sign In button");
        signPage.logIn(email, password);
        Assert.assertTrue(myAccount.getPageTitle().equalsIgnoreCase(myAccountTitle));
        Assert.assertTrue(myAccount.getUsername().equalsIgnoreCase(username), "[Bug 12345] Username is " + myAccount.getUsername() + " instead of " + username); //because username should be name+lastname and here it is name+ 2x lastname
    }

    @Test(priority = 3)
    public void negativeScenario() throws Exception {
        signPage.setEmail(email);
        signPage.clickCreate();
        Thread.sleep(3000);
        Assert.assertTrue(signPage.errorMessageContent().contains(errEmailExists));
        signPage.clearEmailNew();
        signPage.setEmail(justAString);
        signPage.clickCreate();
        Thread.sleep(3000);
        Assert.assertTrue(signPage.errorMessageContent().contains(errEmailInvalidString));
        signPage.clearEmailNew();
        signPage.setEmail(email2);
        signPage.clickCreate();
        Thread.sleep(3000);
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.register();
        createAccount.assertErrors();
    }
}
