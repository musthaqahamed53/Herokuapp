package utility;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportUtil {

    private static final String SCREENSHOT_DIR = "test-output/SparkReport/screenshots/";
    private static final String SCREENSHOT_REL_PATH = "./screenshots/";

    // Log info
    public static void logInfo(String message) {
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, message);
    }

    // Log pass
    public static void logPass(String message) {
        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, message);
    }

    // Log fail
    public static void logFail(String message) {
        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, message);
    }

    // Log warning
    public static void logWarning(String message) {
        ExtentCucumberAdapter.getCurrentStep().log(Status.WARNING, message);
    }

    // Capture and attach screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotLabel) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Make screenshot name safe and unique
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
        String safeLabel = screenshotLabel.replaceAll("[^a-zA-Z0-9]", "_");
        String filename = safeLabel + "_" + timestamp + ".png";
        String fullPath = SCREENSHOT_DIR + filename;
        String relPath = SCREENSHOT_REL_PATH + filename;

        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
            File dest = new File(fullPath);
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Attaching screenshot: " + relPath); // Debug log
            ExtentCucumberAdapter.getCurrentStep().addScreenCaptureFromPath(relPath, screenshotLabel);
        } catch (IOException e) {
            logFail("Failed to attach screenshot: " + e.getMessage());
        }
    }

    // Shortcut: log info with screenshot
    public static void logWithScreenshot(WebDriver driver, String message) {
        logInfo(message);
        captureScreenshot(driver, message);
    }
}
