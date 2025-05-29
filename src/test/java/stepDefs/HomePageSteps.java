package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import utility.TestContextSetup;

public class HomePageSteps {

    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageSteps(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePageObj();
//        System.out.println("homepage cons");
    }

    @Given("User is in HerokuApp Home Page")
    public void user_is_in_heroku_app_home_page() {
        homePage.assertTitle("The Internet");
    }
    @When("User Goes to BasicAuth Page")
    public void user_goes_to_basic_auth_page() {

        System.out.println("user_goes_to_basic_auth_page");
    }
    @Then("^User gives credential (.+) and (.+)$")
    public void user_gives_credential_admin_and_admin(String user,String pass) {
        System.out.println(user+pass);
        homePage.clickBasicAuth(user,pass);
    }
}
