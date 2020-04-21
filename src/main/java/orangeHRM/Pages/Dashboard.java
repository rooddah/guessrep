package orangeHRM.Pages;
import orangeHRM.components.TopPanel;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    private WebDriver driver;
    private final TopPanel topPanel;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.topPanel = new TopPanel(driver);
    }

    public TopPanel topPanel() {
        return topPanel;
    }

}
