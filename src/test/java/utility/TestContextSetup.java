package utility;

import pageObjects.PageObjectManager;

import java.io.IOException;

//Use of this class is to act as a link between classes to store variables and to have objects of the business
// reusables , pageobjectmanager and Drivermanager
public class TestContextSetup {

    public DriverManager driverManager;
    public PageObjectManager pageObjectManager;
    public TestContextSetup() throws IOException {
        this.driverManager = new DriverManager();
        this.pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }
}
