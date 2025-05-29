package utility;

import pageObjects.PageObjectManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Use of this class is to act as a link between classes to store variables and to have objects of the business
// reusables , pageobjectmanager and Drivermanager
public class TestContextSetup {

    public DriverManager driverManager;
    public PageObjectManager pageObjectManager;
    public Reusables reusables;
    public Properties properties;
    public TestContextSetup() throws IOException {
        this.driverManager = new DriverManager();
        this.pageObjectManager = new PageObjectManager(driverManager.getDriver());
        this.reusables = new Reusables(driverManager.getDriver());
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//globalSettings.properties");
        this.properties = new Properties();
        this.properties.load(fis);
    }
}
