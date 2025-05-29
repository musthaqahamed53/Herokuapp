package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.BrokenImagePage;
import utility.TestContextSetup;

import java.util.Map;

public class BrokenImageSteps {

    TestContextSetup testContextSetup;
    BrokenImagePage brokenImagePage;
    public BrokenImageSteps(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.brokenImagePage = testContextSetup.pageObjectManager.getBrokenImagePage();
    }

    @And("User goes to Broken Images Page")
    public void userGoesToBrokenImagesPage() {
        brokenImagePage.openBrokenImageLink();
    }

    @Then("User Validates the Images")
    public void userValidatesTheImages() {
        Map<String,String> statsMap = brokenImagePage.validateImages(this.testContextSetup);
        System.out.println(statsMap);
        for(Map.Entry<String,String> entry:statsMap.entrySet()){

            if(Integer.parseInt(entry.getValue())>=400){
                System.out.println(entry.getKey()+" is Broken");
            }
            else{
                System.out.println(entry.getKey()+" is Not Broken");
            }
        }
    }
}
