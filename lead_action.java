package seleniumtestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.login;

public class lead_action {
	private WebDriver driver;

    @BeforeTest
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void navigateToAddLead() throws InterruptedException {
        // توجه إلى صفحة تحتوي على قائمة ليدات وزر إضافة ليد
    	login login = new login(driver);
        login.login("admin@comp1.com", "123456789");
        driver.findElement(By.xpath("//span[contains(text(),'Leads')]")).click();
        
        // الضغط على أول ليد من القائمة
        driver.findElement(By.xpath("//a[contains(text(),'All Leads')]")).click();
        
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]"));
        WebElement searchInput = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")); // Replace with your search input element ID

        // Enter the phone number
        searchInput.sendKeys("01011941903");

        // Short wait for the search to potentially happen (adjust as needed)
        Thread.sleep(2000);

        // Verify if the phone number is displayed (replace with your verification logic)
        String displayedText = searchInput.getAttribute("value");
        if (displayedText.equals("01011941903")) {
            System.out.println("Phone number displayed correctly!");
        } else {
            System.out.println("Error: Phone number not displayed correctly. Found: " + displayedText);
        }
}
}