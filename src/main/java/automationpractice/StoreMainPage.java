package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreMainPage extends BasePage {


    public StoreMainPage (WebDriver driver) {
        super(driver);
    }
	
	By pageTitle = By.linkText("My Store");
	
	@Override
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
}
