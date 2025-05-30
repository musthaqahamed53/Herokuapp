package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import utility.TestContextSetup;

import java.util.ArrayList;
import java.util.*;
import java.util.Map;

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
        testContextSetup.reusables.sampleReusable();
        System.out.println("user_goes_to_basic_auth_page");
    }
    @Then("^User gives credential (.+) and (.+)$")
    public void user_gives_credential_admin_and_admin(String user,String pass) {
        System.out.println(user+pass);
        homePage.clickBasicAuth(user,pass);
    }

    @Then("^User gives wrong credential (.+) and (.+)$")
    public void user_gives_wrong_credential_admin_and_admin(String user,String pass) {
        System.out.println(user+pass);
        homePage.clickBasicAuthNegative(user,pass);
    }

    @Then("User Validates the links present in the page")
    public void userValidatesTheLinksPresentInThePage() {
        Map<String,String> linkStatus =  homePage.checkPageLinks(testContextSetup);
        List<String> brokenLinks = new ArrayList<>();
        List<String> goodLinks = new ArrayList<>();
        for(Map.Entry<String,String> entry:linkStatus.entrySet()){

            if(Integer.parseInt(entry.getValue())>=400){
                brokenLinks.add(entry.getKey());
//                linkStatus.remove(entry.getKey());
            }
            else{
                goodLinks.add(entry.getKey());
            }
        }
        System.out.println(linkStatus);
        System.out.println(brokenLinks);
        System.out.println(goodLinks);
        Assert.assertTrue((brokenLinks.size()==3));

    }


    @Then("User Navigates to Context click page and Verifies Context Click")
    public void userNavigatesToContextClickPageAndVerifiesContextClick() {
        homePage.openContextClickPage(testContextSetup);
        Assert.assertEquals(homePage.clickContextElement(),"You selected a context menu");
    }

    @Then("User Navigates to Drag and Drop page and Verifies Drag and drop")
    public void userNavigatesToDragAndDropPageAndVerifiesDragAndDrop() {
        homePage.openDragAndDropPage(testContextSetup);
        Assert.assertTrue(homePage.dragAndDropelem(),"Drag and Drop Failed");
    }
}
