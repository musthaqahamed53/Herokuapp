package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public HomePage getHomePageObj(){
        return new HomePage(this.driver);
    }
}
