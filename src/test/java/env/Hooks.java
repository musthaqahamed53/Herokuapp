package env;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.TestContextSetup;

import java.io.File;
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

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.driverManager.getDriver();
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png","image");
        }
    }
}
