package automationpracticeTests;

import automationpractice.CreateAccountPage;
import automationpractice.MyAccount;
import automationpractice.SignInPage;
import automationpractice.StoreMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static automationpractice.BasePage.Countries.UNITED_STATES;
import static automationpractice.BasePage.Months.DECEMBER;
import static automationpractice.BasePage.States.CALIFORNIA;
import static automationpractice.BasePage.Titles.MR;

public class RegistrationTests extends BaseTests {

    protected static WebDriver driver;
    private String URL = "http://automationpractice.com";
    Random rand = new Random();
    int randomStr =  rand.nextInt(900) + 100;
    private String email = "john.doe"+randomStr+"@nicedomain.com";
    private String alreadyRegisteredEmail = "john.doe@nicedomain.com";
    private String email2 = "jane.doe@webpage.com";
    private String password = "pass123";
    private String firstname = "John";
    private String lastname = "Smith";
    private String username = firstname + " " + lastname;
    private String address = "Nice Street 1";
    private String city = "Wonderville";
    private String zip = "54321";
    private String mobile = "1928-3746-55";
    private final String createAccountPageTitle = "Authentication";
    private final String myAccountTitle = "My Account";
    private final String errEmailExists = "has already been registered";
    private final String errEmailInvalidString = "Invalid email address";
    private String justAString = "helloDarknessMyOldFriend";

    private int dayOfBirth = 1;
    private int yearOfBirth = 1985;

    StoreMainPage mainPage;
    SignInPage signPage;
    MyAccount myAccount;
    CreateAccountPage createAccount;

    @BeforeMethod
    public void beforeTest() {
		driver = new FirefoxDriver();
        mainPage = new StoreMainPage(driver);
        signPage = new SignInPage(driver);
        createAccount = new CreateAccountPage(driver);
        myAccount = new MyAccount(driver);
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Clicking 'Sign In' button...");
        mainPage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(signPage.getPageTitle().equalsIgnoreCase("Authentication"));
    }

    @AfterMethod
    public void afterTest() throws Exception {
        if (myAccount.isSignedIn()) {
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
        Assert.assertTrue(createAccount.getPageTitle().equalsIgnoreCase(createAccountPageTitle));
        Assert.assertTrue(createAccount.isEmailPopulated());
        createAccount.setUser(MR, firstname, lastname);
        createAccount.setPassword(password);
        createAccount.secectBirthdayDate(dayOfBirth, DECEMBER, yearOfBirth);
        createAccount.setFirstNameAddr(firstname);
        createAccount.setLastnameAddr(lastname);
        createAccount.setAddress(address, city, UNITED_STATES, CALIFORNIA, zip);
        createAccount.setMobilePhone(mobile);
        createAccount.register();
        Assert.assertTrue(myAccount.getPageTitle().equalsIgnoreCase(myAccountTitle));
    }

    @Test(priority = 2)
    public void logIn() throws Exception {
        System.out.println("Entering email and password and clicking sign In button");
        signPage.logIn(alreadyRegisteredEmail, password);
        Assert.assertTrue(myAccount.getPageTitle().equalsIgnoreCase(myAccountTitle));
        Assert.assertTrue(myAccount.getUsername().equalsIgnoreCase(username), "[Bug 12345] Username is " + myAccount.getUsername() + " instead of " + username); //because username should be name+lastname and here it is name+ 2x lastname
    }

    @Test(priority = 3)
    public void negativeScenario() throws Exception {
        signPage.setEmail(alreadyRegisteredEmail);
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
        createAccount.register();
        createAccount.assertErrors();
    }
}
