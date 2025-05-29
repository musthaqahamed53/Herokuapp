package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Use of this class is to provide WebDriver to the project.
public class DriverManager {

    public WebDriver driver;
    public WebDriver getDriver() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//globalSettings.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("edge")){
                driver = new EdgeDriver();
            }
            driver.get(url);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
