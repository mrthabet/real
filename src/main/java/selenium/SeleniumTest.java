package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        try {
            // Ensure driver is initialized before test
            System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe"); // Replace with your actual path
            WebDriverManager.chromedriver().setup(); // Assuming you're using WebDriverManager
            driver = new ChromeDriver();
            driver.get("https://company1.realstatecrm-main.dev.alefsoftware.com/en/login");
        } catch (Exception e) {
            System.out.println("Error initializing WebDriver: " + e.getMessage());
        }
    }


        // الانتقال إلى صفحة تسجيل الدخول
      //  driver.get("https://company1.realstatecrm-main.dev.alefsoftware.com/en/login");
  //  }

    @Test
    public void testElementLoading() throws InterruptedException {
        // ... (Load a page with an element)

        // Wait for the element to appear
        Thread.sleep(5000); // Wait for 5 seconds

       
    }
    public void testLogin() throws InterruptedException {
        
    	// إدخال اسم المستخدم وكلمة المرور
    	Thread.sleep(5000); // Wait for 5 seconds
    	driver.findElement(By.id("email")).sendKeys("admin@comp1.com");
    	Thread.sleep(5000); // Wait for 5 seconds
        driver.findElement(By.id("password")).sendKeys("123456789");
        Thread.sleep(5000); // Wait for 5 seconds
        // الضغط على زر تسجيل الدخول
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        // التحقق من تسجيل الدخول بنجاح
        if (driver.findElement(By.cssSelector(".dashboard-container")).isDisplayed()) {
            System.out.println("تم تسجيل الدخول بنجاح!");
        } else {
            System.out.println("فشل تسجيل الدخول.");
        }
    }

  //  @AfterTest
    public void teardown() {
        // إغلاق المتصفح
        driver.quit();
    }
}