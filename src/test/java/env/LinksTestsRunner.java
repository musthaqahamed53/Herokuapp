package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/HomePageTest.feature",
        glue = {"stepDefs", "env"},
        tags = "@Links",
        plugin = {
                "pretty",
                "html:target/links-tests.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class LinksTestsRunner extends AbstractTestNGCucumberTests {}
