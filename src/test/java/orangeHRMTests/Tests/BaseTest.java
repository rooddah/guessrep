package orangeHRMTests.Tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public String URL = "https://opensource-demo.orangehrmlive.com/";
    public String username;
    public String password;

    Properties prop = new Properties();

    public void loadprop() throws IOException {
        prop.load(new FileInputStream("src/data.properties"));
        username = prop.getProperty("usernameAP");
        password = prop.getProperty("pwdAP");
    }

}
