package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Reusables;
import utility.TestContextSetup;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BrokenImagePage {
    public WebDriver driver;

    public BrokenImagePage(WebDriver driver){
        this.driver = driver;
    }
    public By imagePageLink = By.xpath("//a[contains(text(),'Broken')]");
    public By imagePageh3 = By.xpath("//h3[contains(text(),'Broken')]");
    public By imagesLoc = By.xpath("//div/img");
    public void openBrokenImageLink() {
        driver.findElement(imagePageLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(imagePageh3));

    }

    public Map<String,String> validateImages(TestContextSetup Tss) {
        List<WebElement> images = driver.findElements(imagesLoc);
        Map<String,String> linkStatus = new LinkedHashMap<>();
        String url = Tss.properties.getProperty("url");
        for(WebElement image :images){
            String tempUrl = Objects.requireNonNull(image.getDomAttribute("src"));
            tempUrl = tempUrl.startsWith("/") ? tempUrl : "/".concat(tempUrl);
            String tempLink =  url.concat(tempUrl);
            linkStatus.put(tempLink, Reusables.getLinkStatus(tempLink));
        }
        return linkStatus;
    }
}
