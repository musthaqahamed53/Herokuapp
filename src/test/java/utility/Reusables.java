package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class Reusables {
    public WebDriver driver;
    public Reusables(WebDriver driver){
        this.driver = driver;
    }

    public void sampleReusable(){
        System.out.println("This is the sample");
    }

    public static String getLinkStatus(String linkUrl){
        try{
            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.connect();
            int code = connection.getResponseCode();
            return String.valueOf(code);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyUrlContains(String urlPart){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains(urlPart));
    }
}
