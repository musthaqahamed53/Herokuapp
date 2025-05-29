package env;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utility.TestContextSetup;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Before
    public void beforeHook(){
        System.out.println("Before Hooks");
    }

    @After
    public void tearDown() throws IOException {
        testContextSetup.driverManager.getDriver().quit();
    }
}
