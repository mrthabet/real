package seleniumtestcases;

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
import selenium.ExtenthtmlReporter;
import selenium.login;

public class dashboard {

    private WebDriver driver;
    private ExtentReports extent;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     // Create ExtentReports instance
        ExtenthtmlReporter htmlReporter = new ExtenthtmlReporter();
    }

    @Test
    public void testDashboardAccess() {
        

        driver.get("https://company1.realstatecrm-main.dev.alefsoftware.com/en/dashboard");
        login login = new login(driver);
        login.login("admin@comp1.com", "123456789");
    }
   
}
