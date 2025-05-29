package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/HomePageTest.feature",
        glue = {"stepDefs", "env"},
        tags = "@AuthPositive or @AuthNegative",
        plugin = {
                "pretty",
                "html:target/auth-tests.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class AuthTestsRunner extends AbstractTestNGCucumberTests {}
