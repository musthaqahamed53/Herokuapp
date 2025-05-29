package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public By basicAuth = By.xpath("//a[text()='Basic Auth']");
    public By authConfirm = By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]");

    public void assertTitle(String theInternet) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isTitleLoaded = wait.until(ExpectedConditions.titleIs(theInternet));
        Assert.assertTrue(isTitleLoaded);
        System.out.println("Title is Loaded");
    }

    public void clickBasicAuth(String username,String password) {
        String authUrl = "https://the-internet.herokuapp.com/basic_auth";
        assert authUrl != null;
        String newAuthUrl = authUrl.replace("https://","https://" + username + ":" + password + "@");
        driver.get(newAuthUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("basic_auth"));

        try{
            Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(authConfirm), "Congratulations")),"AuthenticationFailed");
        }
        catch (NoSuchElementException e){
            System.out.println("❌ Login failed: Auth popup likely shown. Test failed.");
            Assert.fail();
        }
    }
}
