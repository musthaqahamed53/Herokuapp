package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, features = {"src/test/resources/features/HomePageTest.feature"}, glue = {"stepDefs", "env"},
        monochrome = true)
public class mainRunner extends AbstractTestNGCucumberTests {
}
