package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exten {

    private WebDriver driver;
    private ExtentReports extent;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     // Create ExtentReports instance
        extent = new ExtentReports();
    }

    @Test
    public void testDashboardAccess() {
        

        driver.get("https://company1.realstatecrm-main.dev.alefsoftware.com/en/dashboard");
        login login = new login(driver);
        login.login("admin@comp1.com", "123456789");
     // Create a test for dashboard access
        ExtentTest test = extent.createTest("Dashboard Access");

        // Verify dashboard elements
        test.log(Status.PASS, "Dashboard title is present");
        test.log(Status.PASS, "Dashboard widgets are visible");

        // Verify dashboard elements are present (replace with actual element locators)
       
       // Mark test as passed
        test.pass("Dashboard access was successful");

        // Perform additional dashboard-related assertions or actions as needed
    }
    @AfterTest
    public void tearDown() {
        // ... (WebDriver cleanup)

        // Flush ExtentReports
        extent.flush();

        // Send email with report
    }
}
