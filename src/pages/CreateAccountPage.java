package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CreateAccountPage extends BasePage {

    int index = 0;

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getPageTitle() {
        return driver.findElement(pageSubtitle).getText().trim();
    }

    By pageSubtitle = By.className("navigation_page");
    By firstName = By.name("customer_firstname");
    By lastName = By.name("customer_lastname");
    By email = By.name("email");
    By password = By.name("passwd");
    By firstNameAddr = By.name("firstname");
    By lastNameAddr = By.name("customer_lastname");

    private WebElement dropdownDays() {
        return driver.findElement(By.name("days"));
    }

    private WebElement dropdownMonths() {
        return driver.findElement(By.name("months"));
    }

    private WebElement dropdownYears() {
        return driver.findElement(By.name("years"));
    }

    private WebElement dropdownState() {
        return driver.findElement(By.id("id_state"));
    }

    private WebElement dropdownCountry() {
        return driver.findElement(By.id("id_country"));
    }

    private WebElement radioTitle (Titles pTitle) {
        if (pTitle.toString().equalsIgnoreCase("mrs.")) {
            index = 2;
        } else if (pTitle.toString().equalsIgnoreCase("mr.")) {
            index = 1;
        } else {
            System.err.println("There is no such radio button");
        }
        return driver.findElement(By.xpath("//input[@name='id_gender' and @value='" + index + "']"));
    }

    private WebElement checkboxNewsletter() {
        return driver.findElement(By.name("newsletter"));
    }

    private WebElement checkSpecialOffers() {
        return driver.findElement(By.name("optin"));
    }

    private WebElement inputCompany() {
        return driver.findElement(By.name("company"));
    }

    private WebElement inputAddress1() {
        return driver.findElement(By.name("address1"));
    }

    private WebElement inputAddress2() {
        return driver.findElement(By.name("address2"));
    }

    private WebElement inputCity() {
        return driver.findElement(By.name("city"));
    }

    private WebElement inputZipCode() {
        return driver.findElement(By.name("postcode"));
    }

    private WebElement inputAdditionalInfo() {
        return driver.findElement(By.xpath("//p[@class='textarea form-group']////textarea[@class='form-control']"));
    }

    private WebElement inputHomePhone() {
        return driver.findElement(By.name("phone"));
    }

    private WebElement inputMobilePhone() {
        return driver.findElement(By.name("phone_mobile"));
    }

    private WebElement inputAssignAddress() {
        return driver.findElement(By.name("alias"));
    }

    private WebElement buttonRegister() {
        return driver.findElement(By.name("submitAccount"));
    }

    public void selectRadioTitle(Titles pTitle) throws Exception {
        radioTitle(pTitle).click();
    }

    public boolean isElementSelected(WebElement elem) {
        boolean selected = false;
        if (elem.isSelected()) {
            selected = true;
        } else {
            System.out.println("Element '" + elem.getText() + "' has not been selected");
        }
        return selected;
    }

    public void setFirstName(String pFirstname) throws Exception {
        driver.findElement(firstName).sendKeys(pFirstname);
    }

    public void setLastName(String pLastname) throws Exception {
        driver.findElement(lastName).sendKeys(pLastname);
    }

    public void setEmail(String pEmail) throws Exception {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(pEmail);
    }

    public boolean isEmailPopulated() throws Exception {
        boolean populated = false;
        String val = driver.findElement(email).getAttribute("value");
        if (val != null) {
            populated = true;
        } else {
            System.err.println("Email has not been populated by default");
        }
        return populated;
    }

    public void setPassword(String pPassword) throws Exception {
        driver.findElement(password).sendKeys(pPassword);
    }

    public void selectDayOfBirth(int pDay) throws Exception {
        Select birthDay = new Select(dropdownDays());
        String  dayString = String.valueOf(pDay);
        if (dropdownDays() != null) {
            if (pDay >= 1 && pDay <= 31) {
                birthDay.selectByValue(dayString);
            } else {
                System.err.println("Such day does not exist");
            }
        }
    }

    public void selectMonthOfBirth(Months pMonth) throws Exception {
        Select birthMonth = new Select(dropdownMonths());
        if (dropdownMonths() != null) {
            birthMonth.selectByValue(pMonth.toString());
        }
    }

    public void selectYearOfBirth(int pYear) throws Exception {
        Select birthYear = new Select(dropdownYears());
        String yearString = String.valueOf(pYear);
        if (dropdownYears() != null) {
            birthYear.selectByValue(yearString);
        }
    }

    public void selectCheckboxNewsletter() throws Exception {
        checkboxNewsletter().click();
    }

    public void selectCheckboxSpecialOffer() throws Exception {
        checkSpecialOffers().click();
    }

    public void setFirstNameAddr(String pFirstname) throws Exception {
        driver.findElement(firstNameAddr).sendKeys(pFirstname);
    }

    public void setLastnameAddr(String pLastname) throws Exception {
        driver.findElement(lastNameAddr).sendKeys(pLastname);
    }

    public void selectCountry(Countries pCountry) throws Exception {
        Select countries = new Select(dropdownCountry());
        countries.selectByVisibleText(pCountry.toString());
    }

    public void setAddress1(String pAddress) throws Exception {
        inputAddress1().sendKeys(pAddress);
    }

    public void setAddress2(String pAddress2) throws Exception {
        inputAddress2().sendKeys(pAddress2);
    }

    public void setCity(String pCity) throws Exception {
        inputCity().sendKeys(pCity);
    }

    public void selectState(States pState) throws Exception {
        Select states = new Select(dropdownState());
        states.selectByVisibleText(pState.toString());
    }

    public void setZipCode(String pZip) throws Exception {
        inputZipCode().sendKeys(pZip);
    }

    public void setAdditionalInfo(String pText) throws Exception {
        inputAdditionalInfo().sendKeys(pText);
    }

    public void setHomePhone(String pNumber) throws Exception {
        inputHomePhone().sendKeys(pNumber);
    }

    public void setMobilePhone(String pNumber) throws Exception {
        inputMobilePhone().sendKeys(pNumber);
    }

    public void setAlias(String pText) throws Exception {
        inputAssignAddress().sendKeys(pText);
    }

    public void register() throws Exception {
        buttonRegister().click();
    }

    public void setValue(WebElement pField, String pValue) throws Exception {
        pField.sendKeys(pValue);
    }

    public List<WebElement> listOfErrors() {
        List<WebElement> list = new ArrayList<WebElement>();
        WebElement elem = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        List<WebElement> olElements = elem.findElements(By.tagName("li"));
        for (WebElement liElement : olElements) {
            list.add(liElement);
        }
        return list;
    }

    public List<String> getListOfErrorsStr() {
        String str = "";
        List<String> newList = new ArrayList<>();
        List<WebElement> list = listOfErrors();
        for (WebElement el : list) {
            str = el.getText();
            newList.add(str);
        }
        return newList;
    }

    public void assertErrors() throws Exception {
        List<String> messages = getListOfErrorsStr();
        Assert.assertTrue(messages.contains(errorMessages.get(0)));
        Assert.assertTrue(messages.contains(errorMessages.get(1)));
        Assert.assertTrue(messages.contains(errorMessages.get(2)));
        Assert.assertTrue(messages.contains(errorMessages.get(3)));
        Assert.assertTrue(messages.contains(errorMessages.get(4)));
        Assert.assertTrue(messages.contains(errorMessages.get(5)));
        Assert.assertTrue(messages.contains(errorMessages.get(6)));
        Assert.assertTrue(messages.contains(errorMessages.get(7)));
    }
}

