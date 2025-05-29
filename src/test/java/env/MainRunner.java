package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(dryRun = false, features = {"src/test/resources/features/HomePageTest.feature", "src/test/resources/features/BrokenImage.feature"},
        glue = {"stepDefs", "env"}, tags = "@Smoke",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"})
public class MainRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
